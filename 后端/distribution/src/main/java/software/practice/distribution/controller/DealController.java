package software.practice.distribution.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.*;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.result.Result;
import software.practice.distribution.service.DealService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 下午 4:59
 * @description ： deal
 */
@RestController
public class DealController {
    @Autowired
    DealService dealService;

    @CrossOrigin
    @PostMapping(value = "/deal/add")
    public Result addDeal(@RequestBody Deal deal) {
        if(dealService.addDeal(deal)){
            return new Result(200);
        }
        return new Result(400,"添加失败");
    }

    @CrossOrigin
    @PostMapping(value = "/deal/list")
    public Result getDealByUser(int page, Byte dealIspass, HttpServletRequest request){
        int user_id = (int)request.getSession().getAttribute("userId");
        List<Deal> list = dealService.getDealsByUserId(user_id,page,dealIspass);
        if(list != null){
            return new Result(200,null,list);
        }
        return new Result(400,"未找到");
    }
}
