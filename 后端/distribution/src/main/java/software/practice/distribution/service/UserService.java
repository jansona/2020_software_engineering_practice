package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    CommunityMapper communityMapper;

    public User getUserByUserId(int userId){
        User user = userMapper.selectByPrimaryKey(userId);
        user.setUserPassword(null);
        return user;
    }

    public int createUser(User user){
        if(userMapper.insert(user) != 1)
            return -1;
        else{
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUserPhoneEqualTo(user.getUserPhone());
            List<User> users = userMapper.selectByExample(example);
            if(users.size()!=1)
                return -1;
            else return users.get(0).getUserId();
        }
    }

    public Boolean updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user) == 1;
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
        List<User> users = userMapper.selectByExampleWithRowbounds(example,new RowBounds((page-1)*10,10));
        for (User user :users){
            user.setUserPassword(null);
        }
        return users;
    }

    public long getTotalPage(){
        return userMapper.countByExample(new UserExample())/10;
    }

    public User getUserInfoByUserId(int userId){
        User user = getUserByUserId(userId);
        user.setCommunity(communityMapper.selectByPrimaryKey(user.getUserCommunity()));
        return user;
    }
}
