package software.practice.distribution.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.List;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/19 下午 2:49
 * @description ：
 */
@Service
public class LoginService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    CommunityMapper communityMapper;

    public int CommunityLogin(String id, String password){
        Community res = communityMapper.selectByPrimaryKey(BasicUtil.covertStrInt(id));
        // 防止XSS攻击
        String pass = HtmlUtils.htmlEscape(password);
        if (res == null){
            return -2;
        }
        if (res.getCommunityPassword().equals(pass)){
            return 1;
        }
        return -1;
    }

    public Pair<Integer,User> UserLogin(String phone, String password){
        String p = HtmlUtils.htmlEscape(phone);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUserPhoneEqualTo(p);
        List<User> res = userMapper.selectByExample(example);
        // 防止XSS攻击
        String pass = HtmlUtils.htmlEscape(password);
        if (res == null || res.size() == 0){
            return new Pair<>(-2,null);
        }
        User user = res.get(0);
        if (user.getUserPassword().equals(pass)){
             user.setCommunity(communityMapper.selectByPrimaryKey(user.getUserCommunity()));
             return new Pair<>(1,user);
        }
        return new Pair<>(-1,null);
    }
}
