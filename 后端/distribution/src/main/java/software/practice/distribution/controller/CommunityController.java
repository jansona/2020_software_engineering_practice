package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.entity.Community;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.CommunityService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @CrossOrigin
    @PostMapping(value = "/community/list")
    public Result getDealByUser(){
        List<Community> communities = communityService.getCommunityList();
        if(communities != null){
            return new Result(200,communities.size(),communities);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @GetMapping(value = "/community/detail")
    public Result getDetail(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        Community community = communityService.getDetailById(id);
        if(community != null){
            return new Result(200,null,community);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @GetMapping(value = "/message/sum")
    public Result getMessageSum(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        long num = communityService.getMessageSum(id);
        return new Result(200,null,num);
    }

    @CrossOrigin
    @PostMapping(value = "/community/set")
    public Result setCommunity(@RequestBody Community community, HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        community.setCommunityId(id);
        if(communityService.setCommunity(community)){
            return new Result(200,"修改成功");
        }
        return new Result(400,"修改失败");
    }
}
