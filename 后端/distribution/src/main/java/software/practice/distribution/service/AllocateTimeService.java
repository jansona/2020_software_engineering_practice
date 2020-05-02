package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.entity.Package;

import java.text.SimpleDateFormat;
import java.util.*;
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
        //把community_interval转化为分钟
        community_interval /= 60;

        Date favorite_startTime = user.getUserFavoriteStarttime();
        //根据community_id查询location表，获取所有location
        List<Location> locations = locationService.getLocationsByCommunity(community.getCommunityId());
        //根据location_id和当前日期查询arrangement表，
        // TODO 去掉分秒时（经过思考，发现不用去掉分秒时，因为不可能安排时间小于now）,去掉分秒时用ArrangementService.roundDownDate()
        // 获取所有arrangement_location in location_id s里,且arrangement_time大于今天日期的arrangement
        List<Integer> location_ids = new ArrayList<>();
        for (Location l:locations) {
            location_ids.add(l.getLocationId());
        }
        List<Arrangement> arrangements = arrangementService.getArrangementsByLocationIdsAndNow(location_ids);

        int parts = 720/community_interval;  //8:00-20:00可用分区的个数
        int favorite_index = transformTimeToIndex(favorite_startTime,parts);

        //用一个哈希表存储location_id和数组索引之间的对应关系
        //HashMap<Integer,Integer> ids = new HashMap<>(); //location_id:数组索引
        //for(int i =0;i<location_ids.size();i++){
        //    ids.put(location_ids.get(0),i);
        //}

        HashMap<Integer,Integer[][]> maps = new HashMap<>();  //location_id:天数时间段数组
        for (Integer id:location_ids) {
            Integer allocate_table[][] = new Integer[3][parts];
            //初始化二维数组，已经分配过的分区置1，未分配置0
            for (Arrangement a:arrangements) {
                Integer index = transformTimeToIndex(a.getArrangementTime(),parts);
                int arrange_month = a.getArrangementTime().getMonth();
                Date now_date = new Date();
                int now_month = now_date.getMonth();
                if(arrange_month>=now_month){
                    int betweenDays = (int)((a.getArrangementTime().getTime()-now_date.getTime()) / (1000L*3600L*24L));
                    if(betweenDays>=0){
                        allocate_table[betweenDays][index] = 1;
                    }
                }
            }
            maps.put(id,allocate_table);
        }

        Arrangement arrangement = null;
        Date now = new Date();
        int now_index = transformTimeToIndex(now,parts);
        for(int round = 0;round<5;round++){
            for (Integer id:location_ids) {
                Integer a[][] = maps.get(id);
                for(int i = 0;i<a.length;i++){
                    for(int j = now_index+round;i<a[0].length;j++){
                        if(a[i][j]==0){
                            arrangement = new Arrangement();
                            arrangement.setArrangementLocation(id);
                            arrangement.setArrangementPackage(p.getPackageId());
                            arrangement.setArrangementTime(getArrangementTime(now,i,now_index,community_interval));
                            arrangementService.insertArrangement(arrangement);
                            break;
                        }
                    }
                }
            }
        }

        //还是没有空余时间段
        if(arrangement==null){
            System.out.println("在您期望的自提时间段附近暂无空闲自提点");
        }

    }

    public int transformTimeToIndex(Date date,int parts){
        int begin_minutes = 480;  //早上八点：480分钟

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");

        String favorite = simpleDateFormat.format(new Date());
        int favorite_minutes = Integer.parseInt(favorite.substring(0,1))*60+Integer.parseInt(favorite.substring(3,4));

        int index = (favorite_minutes - begin_minutes + 10)/parts;  //延迟10分钟以免出现bug
        return index;
    }

    public Integer getKey(HashMap<Integer,Integer> map,Integer value){
        Integer key = null;
        for(Integer getKey: map.keySet()){
            if(map.get(getKey).equals(value)){
                key = getKey;
            }
        }
        return key;
    }

    public Date getArrangementTime(Date now,int day,int index,int community_interval){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int now_year = calendar.get(Calendar.YEAR);
        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int now_month = calendar.get(Calendar.MONTH)+1;
        int now_date = calendar.get(Calendar.DAY_OF_MONTH);
        int now_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int now_minute = calendar.get(Calendar.MINUTE);

        int minutes = 480 + index * community_interval;
        int hour = minutes/60;
        int minute = minutes%60;
        calendar.set(now_year,now_month,now_date,hour,minute);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

}
