package software.practice.distribution.service;

import javafx.util.Pair;
import org.apache.ibatis.session.RowBounds;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.PackageExample;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.PackageMapper;
import software.practice.distribution.mapper.UserMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 下午 5:55
 * @description ：
 */
@Service
public class PackageService {
    @Autowired
    PackageMapper packageMapper;
    @Autowired
    UserMapper userMapper;

    public Pair<Long, List<Package>> getPackages(int page, Integer id, String user, String content, int communityId) {
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        if (user != null && !user.isEmpty()) {
            uc.andUserNameLike("%" + user + "%");
        }
        uc.andUserCommunityEqualTo(communityId);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            return null;
        }
        List<Integer> userIds = users.stream().map(User::getUserId).collect(Collectors.toList());


        PackageExample example = new PackageExample();
        PackageExample.Criteria criteria = example.createCriteria();
        //userId必须筛选，因为这样才能经过community筛选
        criteria.andPackageUserIn(userIds);
        if (id != null && id != 0) {
            criteria.andPackageIdEqualTo(id);
        }
        if (content != null) {
            criteria.andPackageContentLike("%" + content + "%");
        }
        List<Package> packages = packageMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * 10, 10));
        long totalPage = getTotalPage(example);
        return new Pair<>(totalPage,packages);
    }

    public boolean addPackage(Package p) {
        return packageMapper.insert(p) == 1;
    }

    public boolean editPackage(Package p) {
        return packageMapper.updateByPrimaryKey(p) == 1;
    }

    public boolean removePackage(int id) {
        return packageMapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean removePackages(Integer[] ids) {
        for (int id : ids) {
            packageMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    public long getTotalPage(PackageExample example) {
        return packageMapper.countByExample(example);
    }

    public Pair<Boolean, String> writeFileToData(MultipartFile file, String suffix) throws IOException, InvalidFormatException {
        Workbook wb = WorkbookFactory.create(file.getInputStream());
        if (wb == null){
            return new Pair<>(false, "Excel文件为空");
        }
        Sheet sheet = wb.getSheetAt(0);
        if (sheet == null){
            return new Pair<>(false, "Excel文件为空");
        }

        int contentIndex = -1;
        int phoneIndex = -1;
        int idCardIndex = -1;

        Row row = sheet.getRow(0);
        if (row == null || row.getPhysicalNumberOfCells() == 0) {
            return new Pair<>(false, "没有扫描到表头，请添加表头标识物资内容和手机号/身份证号列");
        }

        for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
            Cell cell = row.getCell(i);
            String value = cell.getStringCellValue();
            if (value.contains("内容")) {
                contentIndex = i;
            } else if (value.contains("手机") || value.contains("电话")) {
                phoneIndex = i;
            } else if (value.contains("身份证")) {
                idCardIndex = i;
            }
        }

        if (contentIndex == -1 && phoneIndex == -1 && idCardIndex == -1) {
            return new Pair<>(false, "没有扫描到表头，请添加表头标识物资内容和手机号/身份证号列");
        }

        if (contentIndex == -1) {
            return new Pair<>(false, "没有扫描到\"内容\"列，请检查表头是否标明内容");
        }
        if (phoneIndex == -1 && idCardIndex == -1) {
            return new Pair<>(false, "没有扫描到\"手机\"或\"电话\"或\"身份证\"列，请检查表头是否标明内容");
        }

        //第一行是列名，所以不读
        int firstRowIndex = sheet.getFirstRowNum() + 1;
        int lastRowIndex = sheet.getLastRowNum();

        //创建一个错误信息
        StringBuilder err = new StringBuilder();

        for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
            row = sheet.getRow(rIndex);
            if (row != null) {
                Cell contentCell = row.getCell(contentIndex);
                Package p = new Package();
                String content = contentCell.getStringCellValue();
                p.setPackageContent(content);
                boolean isSucceed = false;
                if (phoneIndex != -1) {
                    Cell phoneCell = row.getCell(phoneIndex);
                    String phone = phoneCell.getStringCellValue();
                    UserExample example = new UserExample();
                    UserExample.Criteria criteria = example.createCriteria();
                    criteria.andUserPhoneEqualTo(phone);
                    List<User> users = userMapper.selectByExample(example);
                    if (users != null && !users.isEmpty()) {
                        int userId = users.get(0).getUserId();
                        p.setPackageUser(userId);
                        addPackage(p);
                        isSucceed = true;
                    }
                }
                //如果手机号读取成功就直接读下一行
                if (isSucceed) continue;
                //否则判断是否有身份证数据
                if (idCardIndex != -1) {
                    Cell idCardCell = row.getCell(idCardIndex);
                    String idCard = idCardCell.getStringCellValue();
                    UserExample example = new UserExample();
                    UserExample.Criteria criteria = example.createCriteria();
                    criteria.andUserIdcardEqualTo(idCard);
                    List<User> users = userMapper.selectByExample(example);
                    if (users != null && !users.isEmpty()) {
                        int userId = users.get(0).getUserId();
                        p.setPackageUser(userId);
                        addPackage(p);
                        //添加成功就添加下一个
                        continue;
                    }
                } else {
                    err.append("第").append(rIndex).append("行数据手机号错误或系统中查无此人，并且没有身份证号，添加失败\n");
                }
                //身份证还错误
                err.append("第").append(rIndex).append("行数据手机号和身份证号都错误或系统中查无此人，添加失败\n");
            }
        }

        //全部添加完后，返回错误信息

        if (err.toString().isEmpty()) {
            return new Pair<>(true, null);
        }
        err.append("其余都添加成功，再次上传时请删除这些数据");
        return new Pair<>(false, err.toString());
    }

    public Map<String, Long> getPackageCountByUser(int communityId){
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        uc.andUserCommunityEqualTo(communityId);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            return null;
        }

        Map<String, Long> map = new HashMap<>();
        for (User user : users) {
            PackageExample example = new PackageExample();
            PackageExample.Criteria criteria = example.createCriteria();
            criteria.andPackageUserEqualTo(user.getUserId());
            long count = packageMapper.countByExample(example);
            map.put(user.getUserName(),count);
        }
        return map;
    }
}
