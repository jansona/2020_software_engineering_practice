package software.practice.distribution.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.entity.Application;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.ApplicationService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @CrossOrigin
    @PostMapping(value = "/application/add")
    public Result createApplication(@RequestBody Application application){
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
        List<Application> applications = applicationService.getApplicationByUserId(userId);
        if(applications != null){
            if(applications.size() == 1)
                return new Result(200,null,applications.get(0));
            else
                return new Result(400,"找到重复Applications");
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
