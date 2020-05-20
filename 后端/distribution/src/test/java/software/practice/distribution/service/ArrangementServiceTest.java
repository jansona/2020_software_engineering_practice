package software.practice.distribution.service;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.Arrangement;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class ArrangementServiceTest {

    @Autowired
    ArrangementService arrangementService;

    @Test
    public void getArrangementAndPackageContentByUserId() {
        Pair<Long, List<Arrangement>> pair = arrangementService.getArrangementAndPackageContentByUserId(1,0,1);
        Assert.assertEquals(pair.getValue().size(),2);
    }

    @Test
    public void getArrangement() {
        Pair<Long, List<Arrangement>> pair = arrangementService.getArrangement(1,null,"12",null,null,null,1);
        Assert.assertEquals(pair.getValue().size(),2);
    }

    @Test
    public void getArrangementNum() {
        Assert.assertEquals(arrangementService.getArrangementNum(1),5);
    }

    @Test
    public void removeArrangement() {
        Assert.assertEquals(arrangementService.removeArrangement(1),true);
    }

    @Test
    public void removeArrangements() {
        Integer[] ids = {1,2,3};
        Assert.assertEquals(arrangementService.removeArrangements(ids),true);
    }


    @Test
    public void getArrangementsByLocationIdsAndDate() {
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        List<Arrangement> list = arrangementService.getArrangementsByLocationIdsAndDate(ids,new Date());
        Assert.assertEquals(list.size(),3);
    }


    @Test
    public void insertArrangement() {
        Arrangement arrangement = new Arrangement();
        arrangement.setArrangementLocation(2);
        arrangement.setArrangementPackage(12);
        arrangement.setArrangementTime(new Date());
        Assert.assertEquals(arrangementService.insertArrangement(arrangement),true);
    }

}