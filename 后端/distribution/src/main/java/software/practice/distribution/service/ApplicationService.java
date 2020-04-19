package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.ApplicationExample;
import software.practice.distribution.mapper.ApplicationMapper;

import java.util.Date;
import java.util.List;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    public boolean createApplication(Application application){
        application.setApplicationTime(new Date());
        return applicationMapper.insert(application) == 1;
    }

    public List<Application> getApplications(int id){
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andApplicationCommunityEqualTo(id);
        return applicationMapper.selectByExample(example);
    }

    public boolean passApplication(int id, int isPass){
        Application application = new Application();
        application.setApplicationId(id);
        application.setApplicationIspass((byte)isPass);
        return applicationMapper.updateByPrimaryKeySelective(application) == 1;
    }

    public long getTotalPage(){
        return applicationMapper.countByExample(new ApplicationExample());
    }
}
