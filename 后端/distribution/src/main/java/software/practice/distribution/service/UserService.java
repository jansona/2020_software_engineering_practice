package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.ArrayList;
import java.util.Arrays;
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

    public Boolean updateUser(User user){
        int ret = userMapper.updateByPrimaryKey(user);
        return (ret==1)?true:false ;
    }

    public List<User> getUsers(int page, Integer id, String name, String home, int communityId){

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserCommunityEqualTo(communityId);
        if (id != null && id != 0){
            criteria.andUserIdEqualTo(id);
        }
        if (name != null && !name.isEmpty()){
            criteria.andUserNameEqualTo(name);
        }
        if (home != null && !home.isEmpty()){
            criteria.andUserAddressLike("%" + home + "%");
        }
        return userMapper.selectByExampleWithRowbounds(example,new RowBounds((page-1)*10,10));
    }

    public long getTotalPage(){
        return userMapper.countByExample(new UserExample())/10;
    }

    public List<Object> getUserInfoByUserId(int userId){
        User user = getUserByUserId(userId);
        Community community = communityMapper.selectByPrimaryKey(user.getUserCommunity());
        return Arrays.asList(user,community);
    }
}
