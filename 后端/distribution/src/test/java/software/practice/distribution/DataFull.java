package software.practice.distribution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.practice.distribution.entity.*;
import software.practice.distribution.entity.Package;
import software.practice.distribution.mapper.*;

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
    PackageMapper packageMapper;

    @Autowired
    DealMapper dealMapper;

    @Autowired
    ArrangementMapper arrangementMapper;

    @Autowired
    ApplicationMapper applicationMapper;

    // 只用来填充测试数据，一台电脑从头到尾只执行一次
    @Test
    public void full(){
        // 5个小区
        for (int i = 0; i < 5 ; i++) {
            Community community = new Community();
            community.setCommunityId(i + 1);
            community.setCommunityName("第" + (i + 1) + "小区");
            community.setCommunityPassword("123456");
            communityMapper.insert(community);
            // 每个小区20个人，共100人
            for (int j = 0; j < 20; j++) {
                User user = new User();
                user.setUserId(j + 20 * i + 1);
                user.setUserName("用户" + (j + 20 * i + 1));
                if(i != 4) user.setUserCommunity(i + 1);
                user.setUserAddress((i + 1) +"号楼 门牌号" + (j + 1));
                user.setUserPassword("123456");
                user.setUserIdcard("100000199901010001");
                user.setUserFavoriteStarttime(new Date());
                user.setUserTimeStay(3600);
                userMapper.insert(user);

                // 每人发一条申请
                Application application = new Application();
                application.setApplicationId(j + 20 * i + 1);
                application.setApplicationTime(new Date());
                application.setApplicationUser(j + 20 * i + 1);
                application.setApplicationCommunity(i + 1);
                // 第五号社区全都不处理community
                if(i != 4) application.setApplicationIspass((byte)1);
                applicationMapper.insert(application);

                // 每个人3个包裹，共300个包裹
                for (int k = 0; k < 3; k++) {
                    Package p = new Package();
                    p.setPackageId(k + 3 * (j + 20 * i) + 1);
                    p.setPackageUser(j + 1);
                    p.setPackageContent("口罩5个");
                    packageMapper.insert(p);
                }
            }
        }

        // 30个包裹有特殊请求，10个有回复
        for (int i = 0; i < 30; i++) {
            Deal deal = new Deal();
            deal.setDealId(i + 1);
            deal.setDealTime(new Date());
            deal.setDealPackage(10 * i + 1);
            deal.setDealContent("我想晚点拿");
            deal.setDealType((byte)0);
            if (i % 3 == 0){
                deal.setDealIspass((byte)1);
                deal.setDealResponse("可以，凌晨3点来拿吧");
            }
            dealMapper.insert(deal);
        }


        // 针对100个包裹有安排
        for (int i = 0; i < 100; i++) {
            Arrangement arrangement = new Arrangement();
            arrangement.setArrangementId(i + 1);
            arrangement.setArrangementTime(new Date());
            arrangement.setArrangementLocation((i/10 + 1) + "号物资点");
            arrangement.setArrangementPackage(3 * i + 1);
            arrangementMapper.insert(arrangement);
        }
    }
}
