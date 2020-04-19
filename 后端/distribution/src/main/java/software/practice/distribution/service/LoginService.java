package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.util.HtmlUtils;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.UserMapper;

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

    public int UserLogin(String id, String password){
        User res = userMapper.selectByPrimaryKey(BasicUtil.covertStrInt(id));
        // 防止XSS攻击
        String pass = HtmlUtils.htmlEscape(password);
        if (res == null){
            return -2;
        }
        if (res.getUserPassword().equals(pass)){
            return 1;
        }
        return -1;
    }
}
