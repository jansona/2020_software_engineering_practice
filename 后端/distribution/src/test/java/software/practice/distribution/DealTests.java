package software.practice.distribution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.entity.User;
import software.practice.distribution.service.DealService;
import software.practice.distribution.service.UserService;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 下午 12:17
 * @description ：
 */
@SpringBootTest
public class DealTests {

    @Autowired
    DealService dealService;

    @Autowired
    UserService userService;
    @Test
    public void update(){
        User user = new User();
        user.setUserId(1);
        user.setUserPassword("here");
        userService.updateUser(user);
    }

    @Test
    public void add(){
        Deal deal = new Deal();
        deal.setDealContent("aaa");
        deal.setDealId(1);
        deal.setDealPackage(1);
        dealService.addDeal(deal);
    }

    // TODO 该接口下的getDealsByUserId有变动，暂未修改
//    @Test
//    public void getByUser(){
//        int user = 1;
//        System.out.println(dealService.getDealsByUserId(user));
//    }
    @Test
    public void testTime(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter.format(date));
        Calendar calendar = Calendar.getInstance();
    }
}
