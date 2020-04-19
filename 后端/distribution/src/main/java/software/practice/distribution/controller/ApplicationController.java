package software.practice.distribution.controller;

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
        HttpSession s =  request.getSession();
        int id = (int) request.getSession().getAttribute("communityId");
        List<Application> applications = applicationService.getApplications(id);
        long total = applicationService.getTotalPage();
        if(applications != null){
            return new Result(200,total,applications);
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
