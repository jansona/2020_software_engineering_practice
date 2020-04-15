package software.practice.distribution;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.service.DealService;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 下午 12:17
 * @description ：
 */
@SpringBootTest
public class DealTests {

    @Autowired
    DealService dealService;

    @Test
    public void add(){
        Deal deal = new Deal();
        deal.setDealContent("aaa");
        deal.setDealId(1);
        deal.setDealUser(1);
        deal.setDealPackage(1);
        dealService.addDeal(deal);
    }

    @Test
    public void getByUser(){
        int user = 1;
        System.out.println(dealService.getDealsByUser(user));
    }
}
