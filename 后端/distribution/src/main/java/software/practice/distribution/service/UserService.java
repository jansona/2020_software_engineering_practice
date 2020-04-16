package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    CommunityMapper communityMapper;

    public User getUserByUserId(int userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public Boolean createUser(User user){
        return userMapper.insert(user) == 1;
    }

    public List<User> getUserByNameOrHome(int page, String name, String home){
        List<Integer> communitiesIds = new ArrayList<>();
        if (home != null && !home.isEmpty()){
            CommunityExample communityExample = new CommunityExample();
            CommunityExample.Criteria cc = communityExample.createCriteria();
            cc.andCommunityNameEqualTo(home);
            List<Community> communities = communityMapper.selectByExample(communityExample);
            if (communities == null || communities.isEmpty()){
                return null;
            }
            for(Community community :communities){
                communitiesIds.add(community.getCommunityId());
            }
        }
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (name != null && !name.isEmpty()){
            criteria.andUserNameEqualTo(name);
        }
        if (home != null && !home.isEmpty()){
            criteria.andUserCommunityIn(communitiesIds);
        }
        return userMapper.selectByExampleWithRowbounds(example,new RowBounds((page-1)*10,10));    }
}
