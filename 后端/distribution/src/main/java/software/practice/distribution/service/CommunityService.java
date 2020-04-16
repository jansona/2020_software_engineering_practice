package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.DealMapper;

import java.util.List;

@Service
public class CommunityService {
    @Autowired
    CommunityMapper communityMapper;

    @Autowired
    UserService userService;

    /*public boolean addDeal(Deal deal){
        return dealMapper.insert(deal) == 1;
    }*/

    public Community getCommunityByUserId(int user_id){

        User user = userService.getUserByUserId(user_id);
        Integer communityId = user.getUserCommunity();

        CommunityExample example = new CommunityExample();
        CommunityExample.Criteria criteria = example.createCriteria();
        criteria.andCommunityIdEqualTo(communityId);
        return communityMapper.selectByExample(example).get(0);
    }
}
