package software.practice.distribution.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.Location;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class LocationServiceTest {

    @Autowired
    LocationService locationService;

    @Test
    public void getLocationsByCommunity() {
        List<Location> list = locationService.getLocationsByCommunity(1);
        Assert.assertEquals(list.size(),3);
    }

    @Test
    public void addLocation() {
        Assert.assertEquals(locationService.addLocation("六号自提点", 1),true);
    }

    @Test
    public void removeLocation() {
        Assert.assertEquals(locationService.removeLocation(1),true);
    }

    @Test
    public void modifyLocation() {
        Location location = new Location();
        location.setLocationId(2);
        location.setLocationCommunity(1);
        location.setLocationName("第三自提点");
        Assert.assertEquals(locationService.modifyLocation(location),true);
    }
}