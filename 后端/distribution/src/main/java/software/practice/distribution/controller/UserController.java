package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @CrossOrigin
    @GetMapping(value = "/users/listpage")
    public Result getUser(int page, String id, String name, String home, HttpServletRequest request){
        int communityId = (int) request.getSession().getAttribute("communityId");
        List<User> users = userService.getUsers(page, BasicUtil.covertStrInt(id), name, home, communityId);
        long total = userService.getTotalPage();
        if(users != null && !users.isEmpty()){
            return new Result(200,total,users);
        }
        return new Result(400,"未找到");
    }
    
    @CrossOrigin
    @PostMapping(value = "/user/create")
    public Result createUser(@RequestBody User user){
        if(userService.createUser(user)){
            return new Result(200,null,user);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @PostMapping(value = "/user/edit")
    public Result updateUserInformation(@RequestBody User user){
        if(userService.updateUser(user)){
            return new Result(200,null,user);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @PostMapping(value = "/user/info")
    public Result getUserInformation(HttpServletRequest request){
        int userId = (int)request.getSession().getAttribute("userId");
        List<Object> ol = userService.getUserInfoByUserId(userId);
        if(ol!=null) {
            return new Result(200, null, ol);
        }
        return new Result(400,"未找到");
    }
}
