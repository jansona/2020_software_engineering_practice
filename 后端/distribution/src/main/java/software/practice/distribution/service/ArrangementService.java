package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.entity.Package;
import software.practice.distribution.mapper.ArrangementMapper;
import software.practice.distribution.mapper.PackageMapper;
import software.practice.distribution.mapper.UserMapper;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

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

    public List<Arrangement> getArrangement(int page, int id, String user, int package_id, String location, Time time){
        List<Integer> packageIds = new ArrayList<>();
        if (user != null && !user.isEmpty()){
            //根据user查package
            UserExample userExample = new UserExample();
            UserExample.Criteria uc = userExample.createCriteria();
            uc.andUserNameEqualTo(user);
            List<User> users = userMapper.selectByExample(userExample);
            if (users == null || users.isEmpty()){
                return null;
            }
            //得到package
            List<Integer> userIds = new ArrayList<>();
            for(User user1 : users){
                userIds.add(user1.getUserId());
            }

            PackageExample packageExample = new PackageExample();
            PackageExample.Criteria pc = packageExample.createCriteria();
            pc.andPackageUserIn(userIds);
            List<Package> packages = packageMapper.selectByExample(packageExample);
            if (packages == null || packages.isEmpty()){
                return null;
            }
            for(Package p :packages){
                packageIds.add(p.getPackageId());
            }
        }

        ArrangementExample example = new ArrangementExample();
        ArrangementExample.Criteria criteria = example.createCriteria();
        if(id != 0){
            criteria.andArrangementIdEqualTo(id);
        }
        if(!packageIds.isEmpty()){
            criteria.andArrangementPackageIn(packageIds);
        }
        if (package_id != 0){
            criteria.andArrangementPackageEqualTo(package_id);
        }
        if (location != null && !location.isEmpty()){
            criteria.andArrangementLocationLike("%" + location + "%");
        }
        if (time != null){
            criteria.andArrangementTimeEqualTo(time);
        }

        return arrangementMapper.selectByExampleWithRowbounds(example,new RowBounds((page-1)*10,10));
    }

    public boolean removeArrangement(int id){
        return arrangementMapper.deleteByPrimaryKey(id)==1;
    }

    public boolean removeArrangements(List<Integer> ids){
        for (int id : ids) {
            arrangementMapper.deleteByPrimaryKey(id);
        }
        return true;
    }

    public long getTotalPage(){
        return arrangementMapper.countByExample(new ArrangementExample())/10;
    }
}
