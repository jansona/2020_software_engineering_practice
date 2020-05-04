package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.entity.Community;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.CommunityService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
public class RegisterController {
    @Autowired
    CommunityService communityService;

    @CrossOrigin
    @PostMapping(value = "/register")
    public Result serverRegister(@RequestParam(name = "name") String name,
                              @RequestParam(name = "location") String location,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request) {
        if (name == null || name.isEmpty() || location == null || location.isEmpty()
        || password == null || password.isEmpty()){
            return new Result(400,"信息填写不完整");
        }
        Community community = new Community();
        community.setCommunityName(name);
        community.setCommunityAddress(location);
        community.setCommunityPassword(password);
        int res = communityService.addCommunity(community);
        if (res >= 1){
            HttpSession session = request.getSession();
            session.setAttribute("communityId", community);
            return new Result(200,null,community);
        }
        return new Result(400,"注册失败");
    }
}
