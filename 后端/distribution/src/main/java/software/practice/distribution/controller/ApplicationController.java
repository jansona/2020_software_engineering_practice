package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.Community;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.ApplicationService;
import software.practice.distribution.service.CommunityService;

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

    /*@CrossOrigin
    @PostMapping(value = "/application/list")
    public Result getApplicationList(int application_user){
        if(applicationService.createApplication(application)){
            return new Result(200,null);
        }
        return new Result(400,"未找到");
    }*/
}
