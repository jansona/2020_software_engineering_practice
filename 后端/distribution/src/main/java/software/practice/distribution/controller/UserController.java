package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.UserService;

import java.util.Date;

@RestController
public class UserController {
    @Autowired
    UserService userService;

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
        if(userService.createUser(user)){
            return new Result(200,null,user);
        }
        return new Result(400,"未找到");
    }
}
