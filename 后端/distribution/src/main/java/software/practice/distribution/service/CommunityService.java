package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.ApplicationExample;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.CommunityExample;
import software.practice.distribution.entity.User;
import software.practice.distribution.mapper.ApplicationMapper;
import software.practice.distribution.mapper.CommunityMapper;

import java.util.List;

@Service
public class CommunityService {
    @Autowired
    CommunityMapper communityMapper;

    @Autowired
    UserService userService;

    @Autowired
    DealService dealService;

    @Autowired
    ApplicationMapper applicationMapper;

    public Community getCommunityByUserId(int user_id){

        User user = userService.getUserByUserId(user_id);
        Integer communityId = user.getUserCommunity();
        return communityMapper.selectByPrimaryKey(communityId);
    }

    public List<Community> getCommunityList(){
        CommunityExample example = new CommunityExample();
        return communityMapper.selectByExample(example);
    }

    public Community getDetailById(int communityId){
        return communityMapper.selectByPrimaryKey(communityId);
    }

    public long getMessageSum(int communityId){
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andApplicationCommunityEqualTo(communityId);
        criteria.andApplicationIspassEqualTo((byte)-1);
        long applicationNum = applicationMapper.countByExample(applicationExample);

        long dealNum = dealService.getDealsNum(communityId);

        return applicationNum + dealNum;
    }

    public boolean setCommunity(Community community){
        return communityMapper.updateByPrimaryKeySelective(community) == 1;
    }

    public int addCommunity(Community community){
        return communityMapper.insert(community);
    }
}
