package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.entity.DealExample;
import software.practice.distribution.mapper.DealMapper;

import java.util.List;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 上午 11:14
 * @description ： 申请特殊处理
 */
@Service
public class DealService {
    @Autowired
    DealMapper dealMapper;

    public boolean addDeal(Deal deal){
        return dealMapper.insert(deal) == 1;
    }

    public List<Deal> getDealsByUser(int user_id){
        DealExample example = new DealExample();
        DealExample.Criteria criteria = example.createCriteria();
        criteria.andDealUserEqualTo(user_id);
        return dealMapper.selectByExample(example);
    }
}
