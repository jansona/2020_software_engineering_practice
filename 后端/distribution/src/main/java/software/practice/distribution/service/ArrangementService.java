package software.practice.distribution.service;

import javafx.util.Pair;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.*;
import software.practice.distribution.mapper.ArrangementMapper;
import software.practice.distribution.mapper.LocationMapper;
import software.practice.distribution.mapper.PackageMapper;
import software.practice.distribution.mapper.UserMapper;

import java.sql.Time;
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

    @Autowired
    LocationMapper locationMapper;
    // private Object Pair;

    /*
    小程序端
     */
    public Pair<Long,List<Arrangement>> getArrangementAndPackageContentByUserId(int page,int userId) {
        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria pc = packageExample.createCriteria();
        pc.andPackageUserEqualTo(userId);
        List<Package> packageList = packageMapper.selectByExample(packageExample);

        List<Integer> packageIds = packageList.stream().map(Package::getPackageId).collect(Collectors.toList());

        ArrangementExample example = new ArrangementExample();
        ArrangementExample.Criteria criteria = example.createCriteria();
        criteria.andArrangementPackageIn(packageIds);

        List<Arrangement> arrangements = arrangementMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * 10, 10));
        for (Arrangement arrangement : arrangements) {
            int pid = arrangement.getArrangementPackage();
            Package p = packageMapper.selectByPrimaryKey(pid);
            arrangement.setPackageEntity(p);
            arrangement.setLocationEntity(locationMapper.selectByPrimaryKey(arrangement.getArrangementLocation()));
        }
        long totalPage = getTotalPage(example);
        return new Pair<>(totalPage,arrangements);
    }

    public Pair<Long, List<Arrangement>> getArrangement(int page, Integer id, String user, Integer package_id, String location, Time time, int communityId) {
        //根据user查package
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        //限定社区
        uc.andUserCommunityEqualTo(communityId);
        if (user != null && !user.isEmpty()) {
            uc.andUserNameLike("%" + user + "%");
        }
        List<User> users = userMapper.selectByExample(userExample);
        if (users == null || users.isEmpty()) {
            return null;
        }
        //得到package
        List<Integer> userIds = users.stream().map(User::getUserId).collect(Collectors.toList());
        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria pc = packageExample.createCriteria();
        pc.andPackageUserIn(userIds);
        List<Package> packages = packageMapper.selectByExample(packageExample);

        if (packages == null || packages.isEmpty()) {
            return null;
        }

        List<Integer> packageIds = packages.stream().map(Package::getPackageId).collect(Collectors.toList());

        ArrangementExample example = new ArrangementExample();
        ArrangementExample.Criteria criteria = example.createCriteria();
        criteria.andArrangementPackageIn(packageIds);

        List<Integer> locationIds = null;
        //根据Location查id
        if (location!= null && !location.isEmpty()){
            LocationExample locationExample = new LocationExample();
            LocationExample.Criteria lc = locationExample.createCriteria();
            lc.andLocationCommunityEqualTo(communityId);
            lc.andLocationNameLike("%" + location + "%");
            List<Location> locations = locationMapper.selectByExample(locationExample);
            locationIds = locations.stream().map(Location::getLocationId).collect(Collectors.toList());
        }

        if (id != null && id != 0) {
            criteria.andArrangementIdEqualTo(id);
        }
        if (package_id != null) {
            criteria.andArrangementPackageEqualTo(package_id);
        }
        if (locationIds != null) {
            criteria.andArrangementLocationIn(locationIds);
        }
        if (time != null) {
            criteria.andArrangementTimeEqualTo(time);
        }

        List<Arrangement> arrangements = arrangementMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * 10, 10));
        for (Arrangement arrangement : arrangements) {
            int pid = arrangement.getArrangementPackage();
            Package p = packageMapper.selectByPrimaryKey(pid);
            p.setUserEntity(userMapper.selectByPrimaryKey(p.getPackageUser()));
            arrangement.setPackageEntity(p);
            arrangement.setLocationEntity(locationMapper.selectByPrimaryKey(arrangement.getArrangementLocation()));
        }
        long totalPage = getTotalPage(example);
        return new Pair<>(totalPage,arrangements);
    }

    public long getArrangementNum(int communityId){
        //根据user查package
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        //限定社区
        uc.andUserCommunityEqualTo(communityId);

        List<User> users = userMapper.selectByExample(userExample);
        List<Integer> userIds = users.stream().map(User::getUserId).collect(Collectors.toList());

        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria pc = packageExample.createCriteria();
        pc.andPackageUserIn(userIds);
        List<Package> packages = packageMapper.selectByExample(packageExample);
        List<Integer> packageIds = packages.stream().map(Package::getPackageId).collect(Collectors.toList());

        ArrangementExample arrangementExample = new ArrangementExample();
        ArrangementExample.Criteria criteria = arrangementExample.createCriteria();
        criteria.andArrangementPackageIn(packageIds);

        return arrangementMapper.countByExample(arrangementExample);
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
