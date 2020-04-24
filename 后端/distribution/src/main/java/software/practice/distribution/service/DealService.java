package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.*;
import software.practice.distribution.entity.Package;
import software.practice.distribution.mapper.DealMapper;
import software.practice.distribution.mapper.PackageMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    UserMapper userMapper;

    //客户端
    public List<Deal> getDeals(int communityId){
        UserExample userExample = new UserExample();
        UserExample.Criteria uc = userExample.createCriteria();
        uc.andUserCommunityEqualTo(communityId);
        List<User> users = userMapper.selectByExample(userExample);
        List<Integer> userIds = users.stream().map(User::getUserId).collect(Collectors.toList());

        PackageExample packageExample = new PackageExample();
        PackageExample.Criteria pc = packageExample.createCriteria();
        pc.andPackageUserIn(userIds);
        List<Package> packages = packageMapper.selectByExample(packageExample);
        List<Integer> packageIds = packages.stream().map(Package::getPackageId).collect(Collectors.toList());

        DealExample dealExample = new DealExample();
        DealExample.Criteria criteria = dealExample.createCriteria();
        criteria.andDealPackageIn(packageIds);
        List<Deal> deals = dealMapper.selectByExample(dealExample);
        for (Deal deal : deals) {
            deal.setPackageEntity(packageMapper.selectByPrimaryKey(deal.getDealPackage()));
            deal.getPackageEntity().setUserEntity(userMapper.selectByPrimaryKey(deal.getPackageEntity().getPackageUser()));
        }
        if (deals.isEmpty()) return null;
        return deals;
    }

    public boolean checkDeal(int id, boolean admit, String response){
        Deal originalDeal = dealMapper.selectByPrimaryKey(id);
        Deal deal = new Deal();
        deal.setDealId(id);
        deal.setDealIspass(admit ? (byte) 1 : (byte)0);
        deal.setDealResponse(response);
        if (dealMapper.updateByPrimaryKeySelective(deal) == 1){
            if (originalDeal.getDealType() == 0){
                Package p = packageMapper.selectByPrimaryKey(originalDeal.getDealPackage());
                // TODO 调用算法延迟package时间

                return true;
            } else {
                // TODO 调用算法送货上门

                return true;
            }
        }
        return false;
    }

    public boolean addDeal(Deal deal){
        deal.setDealTime(new Date());
        return dealMapper.insert(deal) == 1;
    }

    public List<Deal> getDealsByUserId(int user_id,int page,Byte dealIspass){
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
        criteria.andDealIspassEqualTo(dealIspass);
        return dealMapper.selectByExampleWithRowbounds(example,
            new RowBounds((page - 1) * 10, 10));
    }
}
