package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.CommunityService;
import software.practice.distribution.service.DealService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @CrossOrigin
    @PostMapping(value = "/community/list")
    public Result getDealByUser(){
        List<Community> communitys = communityService.getCommunityList();
        if(communitys != null){
            return new Result(200,communitys.size(),communitys);
        }
        return new Result(400,"未找到");
    }
}
