package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;

    @CrossOrigin
    @PostMapping(value = "/server/login")
    public Result serverLogin(String id, String password, HttpServletRequest request) {
        int res = loginService.CommunityLogin(id,password);
        if (res == 1){
            HttpSession session = request.getSession();
            session.setAttribute("communityId", BasicUtil.covertStrInt(id));
            return new Result(200);
        } else if (res == -2){
            return new Result(400,"无此账号");
        }
        return new Result(400,"密码错误");
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    public Result userLogin(String id, String password, HttpServletRequest request) {
        int res = loginService.UserLogin(id,password);
        if (res == 1){
            HttpSession session = request.getSession();
            session.setAttribute("userId",BasicUtil.covertStrInt(id));
            return new Result(200);
        } else if (res == -2){
            return new Result(400,"无此账号");
        }
        return new Result(400,"密码错误");
    }
}
