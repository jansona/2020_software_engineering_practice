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

    public List<Package> getPackages(int page, int id, String user, String content){
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        uc.andUserNameEqualTo(user);
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()){
            return null;
        }
        User user1 = users.get(0);

        PackageExample example = new PackageExample();
        PackageExample.Criteria criteria = example.createCriteria();
        if(id != 0){
            criteria.andPackageIdEqualTo(id);
        }
        else if(user != null){
            criteria.andPackageUserEqualTo(user1.getUserId());
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
            userMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    public long getTotalPage(){
        return packageMapper.countByExample(new PackageExample())/10;
    }
}
