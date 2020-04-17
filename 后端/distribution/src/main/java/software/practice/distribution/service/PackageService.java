package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.PackageExample;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.PackageMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

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

    public List<Package> getPackages(int page, Integer id, String user, String content){
        List<Integer> userIds = new ArrayList<>();
        if (user != null && !user.isEmpty()){
            UserExample userExample = new UserExample();
            UserExample.Criteria uc = userExample.createCriteria();
            uc.andUserNameEqualTo(user);
            List<User> users = userMapper.selectByExample(userExample);
            if (users == null || users.isEmpty()){
                return null;
            }
            for (User user1 : users){
                userIds.add(user1.getUserId());
            }
        }

        PackageExample example = new PackageExample();
        PackageExample.Criteria criteria = example.createCriteria();
        if (id != null){
            criteria.andPackageIdEqualTo(id);
        }
        if (user != null && !user.isEmpty()){
            criteria.andPackageUserIn(userIds);
        }
        if (content != null){
            criteria.andPackageContentLike("%"+content+"%");
        }

        return packageMapper.selectByExampleWithRowbounds(example,new RowBounds((page-1)*10,10));
    }

    public boolean addPackage(Package p){
        return packageMapper.insert(p)==1;
    }

    public boolean editPackage(Package p){
        return packageMapper.updateByPrimaryKey(p)==1;
    }

    public boolean removePackage(int id){
        return packageMapper.deleteByPrimaryKey(id)==1;
    }

    public boolean removePackages(List<Integer> ids){
        for (int id : ids) {
            packageMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    public long getTotalPage(){
        return packageMapper.countByExample(new PackageExample());
    }
}
