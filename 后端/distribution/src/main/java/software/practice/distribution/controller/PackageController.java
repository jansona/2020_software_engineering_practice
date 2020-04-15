package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
    @PostMapping(value = "/package/listpage")
    public Result getPackage(@RequestBody int page, int id, int user, String content) {
        List<Package> packages = packageService.getPackages(page,id,user,content);
        if(packages != null){
            return new Result(200,null,packages);
        }
        return new Result(400,"未找到");
    }
}
