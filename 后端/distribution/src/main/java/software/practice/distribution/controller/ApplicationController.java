package software.practice.distribution.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.Community;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @CrossOrigin
    @PostMapping(value = "/application/add")
    public Result createApplication(@RequestBody Application application){
        application.setApplicationIspass((byte)-1);
        if(applicationService.createApplication(application)){
            return new Result(200,null);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @GetMapping(value = "/application/community")
    public Result getApplicationList(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        Pair<Long,List<Application>> applications = applicationService.getApplications(id);
        if(applications != null){
            return new Result(200,applications.getKey(),applications.getValue());
        }
        return new Result(400,"未找到");
    }
    /*
    小程序端
     */
    @CrossOrigin
    @GetMapping(value = "/application/info")
    public Result getApplicationList2(HttpServletRequest request){
        int userId = (int) request.getSession().getAttribute("userId");
        Pair<Application, Community> pair = applicationService.getApplicationByUserId(userId);
        if(pair != null){
            return new Result(200,"找到了",pair);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @GetMapping(value = "/application/check-enroll")
    public Result passApplication(int id, boolean admit){
        int isPass = 0;
        if(admit){
            isPass = 1;
        }
        if(applicationService.passApplication(id, isPass)){
            return new Result(200);
        }
        return new Result(400);
    }
}
