package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Location;
import software.practice.distribution.entity.LocationExample;
import software.practice.distribution.mapper.LocationMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.List;

/**
 * @author ：Yu Jiayi
 */

@Service
public class LocationService {


    @Autowired
    LocationMapper locationMapper;

    //根据community_id查询location表，获取所有location
    public List<Location> getLocationsByCommunity(int community_id){

        LocationExample locationExample = new LocationExample();
        LocationExample.Criteria lc = locationExample.createCriteria();
        lc.andLocationCommunityEqualTo(community_id);
        return locationMapper.selectByExample(locationExample);
    }


}
