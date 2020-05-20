package software.practice.distribution.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class LoginServiceTest {

    @Autowired
    LoginService loginService;

    @Test
    public void communityLogin() {

        Assert.assertEquals(loginService.CommunityLogin("1","123456"),1);
    }

    @Test
    public void userLogin() {

        Assert.assertEquals(loginService.UserLogin("1","123456"),1);
    }
}