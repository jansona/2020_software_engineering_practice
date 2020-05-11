package software.practice.distribution.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.ApplicationExample;
import software.practice.distribution.entity.Community;
import software.practice.distribution.entity.User;
import software.practice.distribution.mapper.ApplicationMapper;
import software.practice.distribution.mapper.CommunityMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    CommunityMapper communityMapper;

    public boolean createApplication(Application application){
        application.setApplicationTime(new Date());
        return applicationMapper.insertSelective(application) == 1;
    }

    public Pair<Long,List<Application>> getApplications(int communityId){
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationCommunityEqualTo(communityId);
        criteria.andApplicationIspassEqualTo((byte)-1);
        List<Application> applications = applicationMapper.selectByExample(example);
        for(Application application : applications){
            User user = userMapper.selectByPrimaryKey(application.getApplicationUser());
            user.setUserPassword(null);
            application.setUser(user);
        }
        long totalPage = applicationMapper.countByExample(example);;
        return new Pair<>(totalPage, applications);
    }

    public boolean passApplication(int id, int isPass){
        Application application = applicationMapper.selectByPrimaryKey(id);
        application.setApplicationIspass((byte)isPass);
        if (isPass == 1){
            User user = new User();
            user.setUserId(application.getApplicationUser());
            user.setUserCommunity(application.getApplicationCommunity());
            userMapper.updateByPrimaryKeySelective(user);
        }
        return applicationMapper.updateByPrimaryKeySelective(application) == 1;
    }

    public Pair<Application,Community> getApplicationByUserId(int userId){
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationUserEqualTo(userId);
        List<Application> applicationList = applicationMapper.selectByExample(example);
        if(applicationList.size() > 0){
            Application application = applicationList.get(applicationList.size()-1);
            Community community = communityMapper.selectByPrimaryKey(application.getApplicationCommunity());
            return new Pair<>(application,community);
        }
        else{
            return  null;
        }
    }
}
