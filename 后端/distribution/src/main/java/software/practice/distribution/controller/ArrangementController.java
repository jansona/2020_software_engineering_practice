package software.practice.distribution.controller;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import software.practice.distribution.Utils.BasicUtil;
import software.practice.distribution.entity.Arrangement;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.ArrangementService;

import javax.servlet.http.HttpServletRequest;
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
    public Result getArrangement(int page, String id, String user, String package_id, String location, String time, HttpServletRequest request) {
        int communityId = (int) request.getSession().getAttribute("communityId");
        Pair<Long, List<Arrangement>> arrangements = arrangementService.getArrangement(page,
                BasicUtil.covertStrInt(id),
                user,
                BasicUtil.covertStrInt(package_id),
                location,
                BasicUtil.covertStrTime(time),
                communityId);
        if(arrangements != null){
            return new Result(200,arrangements.getKey(),arrangements.getValue());
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
    public Result removePackages(Integer[] ids) {
        if (arrangementService.removeArrangements(ids)) {
            return new Result(200);
        }
        return new Result(400,"删除失败");
    }
    /*
    小程序端
     */
    @CrossOrigin
    @GetMapping(value = "/arrangement/list")
    public Result getArrangement2(int page, HttpServletRequest request) {
        Pair<Long,List> pair = arrangementService.getArrangementAndPackageContent(page);
        if(pair != null && pair.getKey()!=null && pair.getValue()!=null){
            return new Result(200,pair.getKey(),pair.getValue());
        }
        return new Result(400,"未找到");
    }
}
