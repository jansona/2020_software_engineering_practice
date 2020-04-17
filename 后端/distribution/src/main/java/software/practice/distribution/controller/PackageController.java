package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Package;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.PackageService;
import software.practice.distribution.Utils.BasicUtil.*;

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
    public Result getPackage(int page, String id, String user, String content) {

        List<Package> packages = packageService.getPackages(page, BasicUtil.covertStrInt(id), user, content);
        long total = packageService.getTotalPage();
        if(packages != null){
            return new Result(200,total,packages);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @PostMapping(value = "/package/add")
    public Result addPackage(@RequestBody Package p) {
        if (packageService.addPackage(p)) {
            return new Result(200);
        }
        return new Result(400,"添加失败");
    }

    @CrossOrigin
    @PostMapping(value = "/package/edit")
    public Result editPackage(@RequestBody Package p) {
        if (packageService.editPackage(p)) {
            return new Result(200);
        }
        return new Result(400,"编辑失败");
    }

    @CrossOrigin
    @GetMapping(value = "/package/remove")
    public Result removePackage(int id) {
        if (packageService.removePackage(id)) {
            return new Result(200);
        }
        return new Result(400,"删除失败");
    }

    @CrossOrigin
    @GetMapping(value = "/package/batchremove")
    public Result removePackages(List<Integer> ids) {
        if (packageService.removePackages(ids)) {
            return new Result(200);
        }
        return new Result(400,"删除失败");
    }
}
