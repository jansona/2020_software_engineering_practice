package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.Location;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.CommunityService;
import software.practice.distribution.service.LocationService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CommunityController {
    @Autowired
    CommunityService communityService;

    @Autowired
    LocationService locationService;

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

    @CrossOrigin
    @GetMapping(value = "/community/location")
    public Result getLocation(HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        List<Location> locations = locationService.getLocationsByCommunity(id);
        if(locations == null){
            return new Result(400,"获取失败");
        }
        if(!locations.isEmpty()){
            return new Result(200,null,locations);
        }
        return new Result(400,"获取失败");
    }

    @CrossOrigin
    @PostMapping(value = "/community/location/add")
    public Result addLocation(@RequestParam String name, HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        if (name == null || name.isEmpty()){
            return new Result(400,"未设置名称");
        }
        if(locationService.addLocation(name,id)){
            return new Result(200,"添加成功");
        }
        return new Result(400,"添加失败");
    }

    @CrossOrigin
    @GetMapping(value = "/community/location/remove")
    public Result removeLocation(@RequestParam String id, HttpServletRequest request){
        int locationId = BasicUtil.covertStrInt(id);
        if(locationService.removeLocation(locationId)){
            return new Result(200,"删除成功");
        }
        return new Result(400,"删除失败");
    }

    @CrossOrigin
    @PostMapping(value = "/community/location/modify")
    public Result modifyLocation(@RequestBody Location location, HttpServletRequest request){
        int id = (int) request.getSession().getAttribute("communityId");
        location.setLocationCommunity(id);
        if(locationService.modifyLocation(location)){
            return new Result(200,"修改成功");
        }
        return new Result(400,"修改失败");
    }
}
