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

    public Community getCommunityByUserId(int user_id){

        User user = userService.getUserByUserId(user_id);
        Integer communityId = user.getUserCommunity();
        return communityMapper.selectByPrimaryKey(communityId);
    }

    public List<Community> getCommunityList(){
        CommunityExample example = new CommunityExample();
        return communityMapper.selectByExample(example);
    }
}
