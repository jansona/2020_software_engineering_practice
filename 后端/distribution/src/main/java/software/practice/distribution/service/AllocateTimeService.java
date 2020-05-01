package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.entity.Package;

import java.util.Date;
import java.util.List;

@Service
public class AllocateTimeService {
    @Autowired
    CommunityService communityService;
    @Autowired
    LocationService locationService;
    @Autowired
    ArrangementService arrangementService;
    @Autowired
    UserService userService;

    //可用时间段为早上8点到晚上20点
    public void allocateTime(Package p){
        // Arrangement arrangement = new Arrangement();
        //根据package获取user_id
        Integer user_id = p.getPackageUser();
        //根据userid查询user表，获取community
        Community community = communityService.getCommunityByUserId(user_id);
        Integer community_interval = community.getCommunityInterval();
        User user = userService.getUserByUserId(user_id);
        Date favorite_starttime = user.getUserFavoriteStarttime();
        //根据community_id查询location表，获取所有location
        List<Location> locations = locationService.getLocationsByCommunity(community.getCommunityId());
        //根据location_id和当前日期（去掉分秒时）查询arrangement表，
        // 获取所有arrangement_location in location_id s里,且arrangement_time大于今天日期的arrangement
        Date now = new Date();



    }

    public int transformFavoriteStartTimeToIndex(Date date){
        return 0;
    }


}
