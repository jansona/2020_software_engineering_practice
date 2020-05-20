package software.practice.distribution.service;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.User;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getUserByUserId() {
        User user = userService.getUserByUserId(1);
        Assert.assertEquals(user.getUserId(),(Integer)1);
    }

    @Test
    public void createUser() {
        User user = new User();
        user.setUserName("lily");
        user.setUserCommunity(1);
        user.setUserAddress("星湖园");
        user.setUserIdcard("410336199806281000");
        user.setUserPassword("123456");
        user.setUserPhone("13838828719");
        user.setUserFavoriteStarttime(new Date());
        Assert.assertNotEquals(userService.createUser(user),-1);
    }

    @Test
    public void getUsers() {
        Pair<Long, List<User>> pair = userService.getUsers(1, 0,  null, null, 1);
        Assert.assertEquals(pair.getValue().size(),1);
    }


    @Test
    public void getUserInfoByUserId() {
        User user = userService.getUserInfoByUserId(1);
        Assert.assertEquals(user.getUserId(),(Integer) 1);
    }

    @Test
    public void getUserNum() {
        Assert.assertEquals(userService.getUserNum(1),5);
    }
}