package software.practice.distribution.controller;

import javafx.util.Pair;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Package;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.PackageService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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

    @CrossOrigin
    @PostMapping(value = "/package/import")
    public Result importPackage(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        if (file == null || file.isEmpty()) {
            return new Result(400,"文件为空，请重新选择");
        }

        String fileName = file.getOriginalFilename();
        // 获取文件的后缀名,比如图片的jpeg,png
        assert fileName != null;
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        if (suffixName.equals(".xls") || suffixName.equals(".xlsx")){
            try {
                Pair<Boolean,String> res = packageService.writeFileToData(file,suffixName);
                if (res.getKey()){
                    return new Result(200,"导入成功！");
                } else {
                    return new Result(400,res.getValue());
                }
            } catch (IOException e) {
                return new Result(400,"文件读取失败");
            } catch (InvalidFormatException e) {
                return new Result(400,"文件后缀名正确但内部格式不正确，请确认是否为xls或xlsx");
            }
        }
        else return new Result(400,"文件格式不正确，请确认是否为xls或xlsx");
    }
}