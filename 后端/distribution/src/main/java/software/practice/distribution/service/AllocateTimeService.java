package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.entity.Package;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        User user = userService.getUserByUserId(user_id);
        //根据userId查询user表，获取community
        Community community = communityService.getDetailById(user.getUserCommunity());
        Integer community_interval = community.getCommunityInterval();

        Date favorite_startTime = user.getUserFavoriteStarttime();
        //根据community_id查询location表，获取所有location
        List<Location> locations = locationService.getLocationsByCommunity(community.getCommunityId());
        //根据location_id和当前日期查询arrangement表，
        // TODO 去掉分秒时（经过思考，发现不用去掉分秒时，因为不可能安排时间小于now）,去掉分秒时用ArrangementService.roundDownDate()
        // 获取所有arrangement_location in location_id s里,且arrangement_time大于今天日期的arrangement

        List<Arrangement> arrangements = arrangementService.getArrangementsByLocationIdsAndNow(locations);



    }

    public int transformFavoriteStartTimeToIndex(Date date){
        return 0;
    }


}
