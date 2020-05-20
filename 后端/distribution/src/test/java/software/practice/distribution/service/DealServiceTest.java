package software.practice.distribution.service;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.Deal;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class DealServiceTest {

    @Autowired
    DealService dealService;

    @Test
    public void getDeals() {
        List<Deal> deals = dealService.getDeals(1);
        Assert.assertEquals(deals.size(),3);
    }

    @Test
    public void getDealsNum() {
        Assert.assertEquals(dealService.getDealsNum(1),3);
    }

    @Test
    public void checkDeal() {
        Assert.assertEquals(dealService.checkDeal(1, true, "可"),true);
    }

    @Test
    public void addDeal() {
        Deal deal = new Deal();
        Byte b = 1;
        deal.setDealType(b);
        deal.setDealContent("我想 ...");
        Assert.assertEquals(dealService.addDeal(deal),true);
    }

    @Test
    public void getDealsByUserId() {
        Byte dealIsPass = 1;
        Pair<Integer,List<Deal>> deals = dealService.getDealsByUserId(1,1,dealIsPass);
        Assert.assertEquals(deals.getValue().size(),3);
    }
}