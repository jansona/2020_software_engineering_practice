package software.practice.distribution.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.CommunityService;
import software.practice.distribution.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    CommunityService communityService;

    @CrossOrigin
    @PostMapping(value = "/login")
    public Result serverLogin(@RequestParam(name = "id") String id,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request) {
        int res = loginService.CommunityLogin(id,password);
        if (res == 1){
            HttpSession session = request.getSession();
            session.setAttribute("communityId", BasicUtil.covertStrInt(id));

            Community community = communityService.getDetailById(Integer.parseInt(id));
            community.setCommunityPassword("");

            return new Result(200, "成功登录", community);
        } else if (res == -2){
            return new Result(400,"无此账号");
        }
        return new Result(400,"密码错误");
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    public Result userLogin(String phone, String password, HttpServletRequest request) {
        Pair<Integer, User> res = loginService.UserLogin(phone,password);
        if (res.getKey() == 1){
            HttpSession session = request.getSession();
            session.setAttribute("userId",res.getValue().getUserId());
            return new Result(200,null,res.getValue());
        } else if (res.getKey() == -2){
            return new Result(400,"无此账号");
        }
        return new Result(400,"密码错误");
    }
}
