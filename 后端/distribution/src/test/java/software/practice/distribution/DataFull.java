package software.practice.distribution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.*;
import software.practice.distribution.mapper.*;
import software.practice.distribution.service.PackageService;

import java.util.Calendar;
import java.util.Date;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/16 下午 10:18
 * @description ： 填充测试数据
 */

@SpringBootTest
public class DataFull {

    @Autowired
    CommunityMapper communityMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PackageService packageService;

    @Autowired
    DealMapper dealMapper;

    @Autowired
    ArrangementMapper arrangementMapper;

    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    LocationMapper locationMapper;

    // 只用来填充测试数据，一台电脑从头到尾只执行一次
    @Test
    public void full(){
        // 5个小区
        for (int i = 0; i < 5 ; i++) {
            Community community = new Community();
            community.setCommunityId(i + 1);
            community.setCommunityName("第" + (i + 1) + "小区");
            community.setCommunityAddress("湖北省武汉市第" + (i + 1) + "大街" + (i + 1) + "号");
            community.setCommunityPassword("123456");
            community.setCommunityInterval(3600);
            communityMapper.insert(community);
            //每个小区10个物资点
            for (int x = 0; x < 10; x++){
                Location location = new Location();
                location.setLocationId(10 * i + x + 1);
                location.setLocationName((i + 1) + "小区" + (x+1) + "号物资点");
                location.setLocationCommunity(i + 1);
                locationMapper.insert(location);
            }
            // 每个小区20个人，共100人
            for (int j = 0; j < 20; j++) {
                User user = new User();
                user.setUserId(j + 20 * i + 1);
                user.setUserName("用户" + (j + 20 * i + 1));
                user.setUserCommunity(i + 1);
                user.setUserAddress((i + 1) +"号楼 门牌号" + (j + 1));
                user.setUserPassword("123456");
                String x = String.valueOf(j);
                if (j < 10) x = "0" + j;
                String idCard = "10000" + i +"19990101"+"00" + x;
                user.setUserIdcard(idCard);
                String phone = "139000" + i + "00" + x;
                user.setUserPhone(phone);
                user.setUserFavoriteStarttime(new Date(2020, Calendar.JANUARY, 1, j/2+8, 0, 0));
                user.setUserTimeStay(3600);
                userMapper.insert(user);

                // 每人发一条申请
                Application application = new Application();
                application.setApplicationId(j + 20 * i + 1);
                application.setApplicationTime(new Date());
                application.setApplicationUser(j + 20 * i + 1);
                application.setApplicationCommunity(i + 1);
                application.setApplicationIspass((byte)1);
                applicationMapper.insertSelective(application);

                // 每个人3个包裹，共300个包裹
                for (int k = 0; k < 3; k++) {
                    Package p = new Package();
                    p.setPackageUser(20 * i + j + 1);
                    p.setPackageContent("口罩"+ (60 * i + 3 * j + k + 1) +"个");
                    packageService.addPackage(p);
                }
            }
        }

//        // 30个包裹有特殊请求，10个有回复
//        for (int i = 0; i < 30; i++) {
//            Deal deal = new Deal();
//            deal.setDealId(i + 1);
//            deal.setDealTime(new Date());
//            deal.setDealPackage(10 * i + 1);
//            deal.setDealContent("我想晚点拿");
//            deal.setDealType((byte)0);
//            if (i % 3 == 0){
//                deal.setDealIspass((byte)1);
//                deal.setDealResponse("可以，凌晨3点来拿吧");
//            } else {
//                deal.setDealIspass((byte)-1);
//            }
//            dealMapper.insert(deal);
//        }


//        // 针对100个包裹有安排
//        for (int i = 0; i < 100; i++) {
//            Arrangement arrangement = new Arrangement();
//            arrangement.setArrangementId(i + 1);
//            arrangement.setArrangementTime(new Date());
//            arrangement.setArrangementLocation(i/2 + 1);
//            arrangement.setArrangementPackage(3 * i + 1);
//            arrangementMapper.insert(arrangement);
//        }
    }
}
