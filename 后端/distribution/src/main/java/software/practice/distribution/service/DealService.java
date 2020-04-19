package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Deal;
import software.practice.distribution.entity.DealExample;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.PackageExample;
import software.practice.distribution.mapper.DealMapper;
import software.practice.distribution.mapper.PackageMapper;

import java.util.ArrayList;
import java.util.Date;
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

    @Autowired
    PackageMapper packageMapper;

    public boolean addDeal(Deal deal){
        deal.setDealTime(new Date());
        return dealMapper.insert(deal) == 1;
    }

    public List<Deal> getDealsByUserId(int user_id){
        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria pc = packageExample.createCriteria();
        pc.andPackageUserEqualTo(user_id);
        List<Package> packages = packageMapper.selectByExample(packageExample);
        if (packages.isEmpty()){
            return null;
        }

        List<Integer> packageIds = new ArrayList<>();
        for(Package p : packages){
            packageIds.add(p.getPackageId());
        }

        DealExample example = new DealExample();
        DealExample.Criteria criteria = example.createCriteria();
        criteria.andDealPackageIn(packageIds);
        return dealMapper.selectByExample(example);
    }
}
