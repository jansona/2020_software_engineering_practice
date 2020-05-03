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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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

    public List<Arrangement> getArrangementsByLocationsAndNow(List<Location> locations){
        ArrangementExample arrangementExample = new ArrangementExample();
        ArrangementExample.Criteria ac = arrangementExample.createCriteria();
        List<Integer> locationIds = locations.stream().map(Location::getLocationId).collect(Collectors.toList());
        ac.andArrangementLocationIn(locationIds);
        ac.andArrangementTimeGreaterThanOrEqualTo(new Date());
        return arrangementMapper.selectByExample(arrangementExample);
    }

    /*
    小程序端
     */
    public Pair<Long, List<Arrangement>> getArrangementAndPackageContentByUserId(int page, int timeType, int userId) {
        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria pc = packageExample.createCriteria();
        pc.andPackageUserEqualTo(userId);
        List<Package> packageList = packageMapper.selectByExample(packageExample);

        if (packageList == null || packageList.isEmpty()) {
            return null;
        }

        List<Integer> packageIds = packageList.stream().map(Package::getPackageId).collect(Collectors.toList());

        ArrangementExample example = new ArrangementExample();
        ArrangementExample.Criteria criteria = example.createCriteria();
        criteria.andArrangementPackageIn(packageIds);

        Date today = getPastDate(0);
        if (timeType == 0) {
            Date past = getPastDate(7);
            criteria.andArrangementTimeBetween(past, today);
            System.out.println(past+"\n"+today);

        } else if (timeType == 1) {
            Date past = getPastDate(1);
            criteria.andArrangementTimeBetween(past, today);
            System.out.println(past+"\n"+today);
        }

        List<Arrangement> arrangements = arrangementMapper.selectByExampleWithRowbounds(example, new RowBounds((page - 1) * 10, 10));
        if (arrangements == null || arrangements.isEmpty()) {
            return null;
        }

        for (Arrangement arrangement : arrangements) {
            int pid = arrangement.getArrangementPackage();
            Package p = packageMapper.selectByPrimaryKey(pid);
            arrangement.setPackageEntity(p);
            arrangement.setLocationEntity(locationMapper.selectByPrimaryKey(arrangement.getArrangementLocation()));
        }
        long totalPage = getTotalPage(example);
        Collections.reverse(arrangements);
        return new Pair<>(totalPage, arrangements);
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
        if (location != null && !location.isEmpty()) {
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
        if (arrangements == null || arrangements.isEmpty()) {
            return null;
        }

        for (Arrangement arrangement : arrangements) {
            int pid = arrangement.getArrangementPackage();
            Package p = packageMapper.selectByPrimaryKey(pid);
            p.setUserEntity(userMapper.selectByPrimaryKey(p.getPackageUser()));
            arrangement.setPackageEntity(p);
            arrangement.setLocationEntity(locationMapper.selectByPrimaryKey(arrangement.getArrangementLocation()));
        }
        long totalPage = getTotalPage(example);
        return new Pair<>(totalPage, arrangements);
    }

    public long getArrangementNum(int communityId) {
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

    public Date getPastDate(int past) {
        past -= 1;
        Date today = roundDownDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - past);
        return calendar.getTime();
    }

    public Date roundDownDate(Date date) {
        Date now = new Date();
        // java.util.Date -> java.time.LocalDate
        LocalDate localDate = now.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        // java.time.LocalDate -> java.sql.Date
        Date newDate = java.sql.Date.valueOf(localDate);
        return newDate;
    }

    // 获取所有arrangement_location in location_id s里,且arrangement_time大于今天日期的arrangement
    public List<Arrangement> getArrangementsByLocationIdsAndDate(List<Integer> location_ids,Date date){
        ArrangementExample arrangementExample = new ArrangementExample();
        ArrangementExample.Criteria ac = arrangementExample.createCriteria();
        ac.andArrangementTimeGreaterThanOrEqualTo(date);
        ac.andArrangementLocationIn(location_ids);
        return arrangementMapper.selectByExample(arrangementExample);
    }

    public String roundDownDate(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    public boolean insertArrangement(Arrangement arrangement){
        return arrangementMapper.insert(arrangement) == 1;

    }

}
