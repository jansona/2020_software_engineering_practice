package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.*;

import java.util.*;

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
    public boolean allocateTime(Package p){
        //根据package获取user
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
        //根据location_id和当前日期查询arrangement表
        // 获取所有arrangement_location in location_id s里,且arrangement_time大于今天日期的arrangement
        List<Integer> location_ids = new ArrayList<>();
        for (Location l:locations) {
            location_ids.add(l.getLocationId());
        }
        List<Arrangement> arrangements = arrangementService.getArrangementsByLocationIdsAndDate(location_ids,new Date());

        int parts = 720/community_interval;  //8:00-20:00可用分区的个数
        int favorite_index = transformTimeToIndex(favorite_startTime,community_interval);

        HashMap<Integer,int[][]> maps = new HashMap<>();  //location_id-天数时间段数组
        int days = 0;
        for (Integer id:location_ids) {
            //假设天数为3
            int[][] allocate_table = new int[3][parts];
            days = 3 ;
            //初始化二维数组，已经分配过的分区置1，未分配置0
            for (Arrangement a:arrangements) {
                if(!a.getArrangementLocation().equals(id))
                    continue;

                int index = transformTimeToIndex(a.getArrangementTime(),community_interval);

                Date arrange_date = a.getArrangementTime();
                Calendar arrange_calendar = Calendar.getInstance();
                arrange_calendar.setTime(arrange_date);
                int arrange_month = arrange_calendar.get(Calendar.MONTH)+1;

                Date now_date = new Date();
                Calendar now_calendar = Calendar.getInstance();
                now_calendar.setTime(now_date);
                int now_month = now_calendar.get(Calendar.MONTH)+1;

                //如果分配时间在今天之前就不用考虑了
                if(arrange_month>=now_month){
                    int betweenDays = (int)((a.getArrangementTime().getTime()-now_date.getTime()) / (1000L*3600L*24L));
                    if(betweenDays>=0){
                        allocate_table[betweenDays][index] = 1;
                    }
                }
            }
            maps.put(id,allocate_table);
            int[][] a = maps.get(id);
        }

        Arrangement arrangement;
        Date now = new Date();
        int index;
        int now_index = transformTimeToIndex(new Date(),community_interval);
        index = Math.max(favorite_index, now_index);
        int round = parts-index-1;
        //int days = maps.get(0).length;

        for (int i = 0; i < days; i++) {
            //推迟一天需要更新index和round
            if (i == 1) {
                index = favorite_index;
                round = parts - index - 1;
            }

            for (int r = 0; r < round; r++) {
                for (Integer id : location_ids) {
                    int[][] a = maps.get(id);
                    if (a[i][index + r] == 0) {
                        arrangement = new Arrangement();
                        arrangement.setArrangementLocation(id);
                        arrangement.setArrangementPackage(p.getPackageId());
                        arrangement.setArrangementTime(getArrangementTime(now, i, index + r, community_interval));
                        arrangementService.insertArrangement(arrangement);
                        return true;
                    }
                }
            }
        }
        //所有天数内自提点都不可用，只能再往后推迟一天
        //查询后一天该时间段是否被占有
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(favorite_startTime);
        cal.set(cal.get(Calendar.YEAR),cal.get(Calendar.MONTH),cal.get(Calendar.DAY_OF_MONTH)+days,cal2.get(Calendar.HOUR_OF_DAY),cal2.get(Calendar.MINUTE));
        List<Arrangement> as = arrangementService.getArrangementsByLocationIdsAndDate(location_ids,cal.getTime());
        if(as==null){
            arrangement = new Arrangement();
            arrangement.setArrangementLocation(location_ids.get(0));
            arrangement.setArrangementPackage(p.getPackageId());
            arrangement.setArrangementTime(getArrangementTime(now, days,index, community_interval));
            arrangementService.insertArrangement(arrangement);
            return true;
        }else{
            //应该不会被占用的...考虑到订单时效性，再往后推迟也没有意义了
            return false;
        }
        
        /*f:for(int round = 0;round<5;round++){
            for (Integer id:location_ids) {
                Integer a[][] = maps.get(id);
                for(int i = 0;i<a.length;i++){
                    for(int j = now_index+round;j<a[0].length;j++){
                        if(a[i][j]==0){
                            arrangement = new Arrangement();
                            arrangement.setArrangementLocation(id);
                            arrangement.setArrangementPackage(p.getPackageId());
                            arrangement.setArrangementTime(getArrangementTime(now,i,now_index,community_interval));
                            arrangementService.insertArrangement(arrangement);
                            break f;
                        }
                    }
                }
            }
        }*/

    }

    public int transformTimeToIndex(Date date,int interval){
        int begin_minutes = 480;  //早上八点：480分钟
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int minutes = calendar.get(Calendar.HOUR_OF_DAY)*60+calendar.get(Calendar.MINUTE);
        int index = (minutes - begin_minutes + 20)/interval;
        return index;
    }

    public Date getArrangementTime(Date now,int day,int index,int community_interval){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        int now_year = calendar.get(Calendar.YEAR);
        // 获取月，这里需要需要月份的范围为0~11，因此获取月份的时候需要+1才是当前月份值
        int now_month = calendar.get(Calendar.MONTH);
        int now_date = calendar.get(Calendar.DAY_OF_MONTH);

        int minutes = 480 + index * community_interval;
        int hour = minutes/60;
        int minute = minutes%60;
        calendar.set(now_year,now_month,now_date,hour,minute);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

}
