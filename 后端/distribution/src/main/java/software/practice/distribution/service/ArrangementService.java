package software.practice.distribution.service;

import javafx.util.Pair;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.*;
import software.practice.distribution.mapper.ArrangementMapper;
import software.practice.distribution.mapper.PackageMapper;
import software.practice.distribution.mapper.UserMapper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/16 下午 9:18
 * @description ：
 */

@Service
public class ArrangementService {
    @Autowired
    ArrangementMapper arrangementMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PackageMapper packageMapper;

    /*
    小程序端
     */
    public Pair<Long,List> getArrangementAndPackageContent(int page) {
        ArrangementExample example = new ArrangementExample();
        List<Arrangement> arrangements =  arrangementMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * 10, 10));
        //查询每个arrangement的packageContent
        List<Pair<Arrangement,String>> list = new ArrayList<>();
        for (Arrangement arrangement : arrangements) {
            int pid = arrangement.getArrangementPackage();
            Package p = packageMapper.selectByPrimaryKey(pid);
            list.add(new Pair(arrangement,p.getPackageContent()));
        }
        return new Pair<>(getTotalPage(example),list);
    }

    public Pair<Long, List<Arrangement>> getArrangement(int page, Integer id, String user, Integer package_id, String location, Time time, int communityId) {
        List<Integer> packageIds = new ArrayList<>();

        //根据user查package
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        //限定社区
        uc.andUserCommunityEqualTo(communityId);
        if (user != null && !user.isEmpty()) {
            uc.andUserNameEqualTo(user);
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            return null;
        }
        //得到package
        List<Integer> userIds = new ArrayList<>();
        for (User user1 : users) {
            userIds.add(user1.getUserId());
            PackageExample packageExample = new PackageExample();
            PackageExample.Criteria pc = packageExample.createCriteria();
            pc.andPackageUserIn(userIds);
            List<Package> packages = packageMapper.selectByExample(packageExample);
            if (packages == null || packages.isEmpty()) {
                return null;
            }
            for (Package p : packages) {
                packageIds.add(p.getPackageId());
            }
        }

        ArrangementExample example = new ArrangementExample();
        ArrangementExample.Criteria criteria = example.createCriteria();

        criteria.andArrangementPackageIn(packageIds);


        if (id != null && id != 0) {
            criteria.andArrangementIdEqualTo(id);
        }
        if (package_id != null) {
            criteria.andArrangementPackageEqualTo(package_id);
        }
        if (location != null && !location.isEmpty()) {
            criteria.andArrangementLocationLike("%" + location + "%");
        }
        if (time != null) {
            criteria.andArrangementTimeEqualTo(time);
        }

        List<Arrangement> arrangements = arrangementMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * 10, 10));
        for (Arrangement arrangement : arrangements) {
            int pid = arrangement.getArrangementPackage();
            Package p = packageMapper.selectByPrimaryKey(pid);
            arrangement.setArrangementUser(p.getPackageUser());
        }
        long totalPage = getTotalPage(example);
        return new Pair<>(totalPage,arrangements);
    }

    public boolean removeArrangement(int id) {
        return arrangementMapper.deleteByPrimaryKey(id) == 1;
    }

    public boolean removeArrangements(Integer[] ids) {
        for (int id : ids) {
            arrangementMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    public long getTotalPage(ArrangementExample example) {
        return arrangementMapper.countByExample(example);
    }
}
