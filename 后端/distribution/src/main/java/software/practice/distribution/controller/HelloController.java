package software.practice.distribution.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/14 下午 12:07
 * @description ： hello
 */
@RestController
@EnableAutoConfiguration
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot ... ";
    }

    @GetMapping("/users/listpage")
    public String test(int page, String name, String room)
    {
        System.out.println(page);
        return "WTF";
    }
}
