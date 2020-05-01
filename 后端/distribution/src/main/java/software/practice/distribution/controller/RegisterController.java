package software.practice.distribution.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.result.Result;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegisterController {

    @CrossOrigin
    @PostMapping(value = "/register")
    public Result serverLogin(@RequestParam(name = "name") String id,
                              @RequestParam(name = "location") String location,
                              @RequestParam(name = "password") String password,
                              HttpServletRequest request) {
        // TODO 注册之后直接登录，所以需要设置session
        return new Result(400,"注册失败");
    }
}
