package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.entity.Package;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.PackageService;

import java.util.List;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 下午 6:13
 * @description ：
 */
@RestController
public class PackageController {
    @Autowired
    PackageService packageService;

    @CrossOrigin
    @GetMapping(value = "/package/listpage")
    public Result getPackage(int page, int id, String user, String content) {
        List<Package> packages = packageService.getPackages(page,id,user,content);
        long total = packageService.getTotalPage();
        if(packages != null){
            return new Result(200,total,packages);
        }
        return new Result(400,"未找到");
    }
}
