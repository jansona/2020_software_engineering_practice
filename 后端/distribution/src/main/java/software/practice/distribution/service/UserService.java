package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.DealExample;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.UserMapper;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserExample example;

    @Autowired
    UserExample.Criteria criteria;

    public User getUserByUserId(int userId){
        criteria.andUserIdEqualTo(userId);
        return userMapper.selectByExample(example).get(0);
    }

    public Boolean createUser(User user){
        return userMapper.insert(user) == 1;
    }
}
