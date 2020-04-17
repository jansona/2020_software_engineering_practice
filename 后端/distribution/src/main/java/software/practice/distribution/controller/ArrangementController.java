package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.entity.Arrangement;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.ArrangementService;

import java.sql.Time;
import java.util.List;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/16 下午 9:13
 * @description ：
 */

@RestController
public class ArrangementController {
    @Autowired
    ArrangementService arrangementService;

    @CrossOrigin
    @GetMapping(value = "/arrangement/listpage")
    public Result getArrangement(int page, int id, String user, int package_id, String location, Time time) {
        List<Arrangement> arrangements = arrangementService.getArrangement(page,id,user,package_id,location,time);
        long total = arrangementService.getTotalPage();
        if(arrangements != null){
            return new Result(200,total,arrangements);
        }
        return new Result(400,"未找到");
    }

    @CrossOrigin
    @GetMapping(value = "/arrangement/remove")
    public Result removePackage(int id) {
        if (arrangementService.removeArrangement(id)) {
            return new Result(200);
        }
        return new Result(400,"删除失败");
    }

    @CrossOrigin
    @GetMapping(value = "/arrangement/batchremove")
    public Result removePackages(List<Integer> ids) {
        if (arrangementService.removeArrangements(ids)) {
            return new Result(200);
        }
        return new Result(400,"删除失败");
    }
}
