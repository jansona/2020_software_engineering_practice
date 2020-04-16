package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Application;
import software.practice.distribution.entity.ApplicationExample;
import software.practice.distribution.entity.User;
import software.practice.distribution.entity.UserExample;
import software.practice.distribution.mapper.ApplicationMapper;
import software.practice.distribution.mapper.UserMapper;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper mapper;

    public Boolean createApplication(Application application){
        return mapper.insert(application) == 1;
    }
}
