package software.practice.distribution.service;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.Community;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class ApplicationServiceTest {

    @Autowired
    ApplicationService applicationService;

    @Test
    public void createApplication() {
        Application application = new Application();
        application.setApplicationUser(1);
        application.setApplicationCommunity(1);
        application.setApplicationIspass((byte)0);
        Assert.assertNotEquals(applicationService.createApplication(application),true);
    }

    @Test
    public void getApplications() {
        Pair<Long, List<Application>> pais = applicationService.getApplications(1);
        Assert.assertEquals(pais.getValue().size(),5);
    }

    @Test
    public void passApplication() {
        Assert.assertEquals(applicationService.passApplication(1,1),true);
    }

    @Test
    public void getApplicationByUserId() {
        Pair<Application, Community> pais = applicationService.getApplicationByUserId(1);
        Assert.assertEquals(pais.getValue().getCommunityId(),(Integer) 1);
    }
}