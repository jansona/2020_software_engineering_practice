package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Application;
import software.practice.distribution.mapper.ApplicationMapper;

import java.util.Date;

@Service
public class ApplicationService {
    @Autowired
    ApplicationMapper mapper;

    public Boolean createApplication(Application application){
        application.setApplicationTime(new Date());
        return mapper.insert(application) == 1;
    }
}
