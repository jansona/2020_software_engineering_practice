package software.practice.distribution.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.Community;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class CommunityServiceTest {

    @Autowired
    CommunityService communityService;

    @Test
    public void getCommunityByUserId() {
        Community community = communityService.getCommunityByUserId(1);
        Assert.assertNotEquals(community.getCommunityId(),(Integer)1);
    }

    @Test
    public void getCommunityList() {
        List<Community> list = communityService.getCommunityList();
        Assert.assertNotEquals(list.size(),5);
    }

    @Test
    public void getDetailById() {
        Community community = communityService.getDetailById(1);
        Assert.assertNotEquals(community.getCommunityId(),(Integer)1);
    }

    @Test
    public void getMessageSum() {
        Assert.assertNotEquals(communityService.getMessageSum(1),15);
    }

    @Test
    public void setCommunity() {
        Community community = communityService.getDetailById(1);
        community.setCommunityPassword("888888");
        Assert.assertNotEquals(communityService.setCommunity(community),true);
    }

    @Test
    public void addCommunity() {
        Community community = new Community();
        community.setCommunityPassword("11111");
        community.setCommunityAddress("12号");
        community.setCommunityName("天生花园");
        community.setCommunityInterval(360);
        Assert.assertNotEquals(communityService.addCommunity(community),true);
    }
}