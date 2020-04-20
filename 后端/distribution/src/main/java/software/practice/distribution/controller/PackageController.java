package software.practice.distribution.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Package;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.PackageService;

import javax.servlet.http.HttpServletRequest;
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
    public Result getPackage(int page, String id, String user, String content, HttpServletRequest request) {
        int communityId = (int) request.getSession().getAttribute("communityId");
        Pair<Long, List<Package>> packages = packageService.getPackages(page,
                BasicUtil.covertStrInt(id),
                user,
                content,
                communityId);
        if(packages != null){
            return new Result(200,packages.getKey(),packages.getValue());
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
    public Result removePackages(Integer[] ids) {
        if (packageService.removePackages(ids)) {
            return new Result(200);
        }
        return new Result(400,"删除失败");
    }
}