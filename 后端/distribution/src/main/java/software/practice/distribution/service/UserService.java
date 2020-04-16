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

    public User getUserByUserId(int userId){
        return userMapper.selectByPrimaryKey(userId);
    }

    public Boolean createUser(User user){
        return userMapper.insert(user) == 1;
    }
}
