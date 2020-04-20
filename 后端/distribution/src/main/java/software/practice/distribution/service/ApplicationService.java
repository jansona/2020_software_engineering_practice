package software.practice.distribution.service;

import javafx.util.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.ApplicationExample;
import software.practice.distribution.entity.User;
import software.practice.distribution.mapper.ApplicationMapper;
import software.practice.distribution.mapper.UserMapper;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    UserMapper userMapper;

    public boolean createApplication(Application application){
        application.setApplicationTime(new Date());
        return applicationMapper.insert(application) == 1;
    }

    public Pair<Long,List<Application>> getApplications(int communityId){
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationCommunityEqualTo(communityId);
//        criteria.andApplicationIspassGreaterThan((byte)-1);
        criteria.andApplicationIspassEqualTo((byte)-1);
        List<Application> applications = applicationMapper.selectByExample(example);
        for(Application application : applications){
            User user = userMapper.selectByPrimaryKey(application.getApplicationUser());
            user.setUserPassword(null);
            application.setUser(user);
        }
        long totalPage = getTotalPage(example);
        return new Pair<>(totalPage, applications);
    }

    public boolean passApplication(int id, int isPass){
        Application application = new Application();
        application.setApplicationId(id);
        application.setApplicationIspass((byte)isPass);
        return applicationMapper.updateByPrimaryKeySelective(application) == 1;
    }

    public long getTotalPage(ApplicationExample example){
        return applicationMapper.countByExample(example);
    }

    public List<Application> getApplicationByUserId(int userId){
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationUserEqualTo(userId);
        return applicationMapper.selectByExample(example);
    }
}
