package software.practice.distribution.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Arrangement;
import software.practice.distribution.entity.Package;

import java.util.Date;

@Service
public class AllocateTimeService {
    @Autowired
    CommunityService communityService;
    @Autowired
    LocationService locationService;
    @Autowired
    ArrangementService arrangementService;

    //可用时间段为早上8点到晚上20点
    public void allocateTime(Package p){
        //
        // Arrangement arrangement = new Arrangement();

    }

    public int transformFavoriteStartTimeToIndex(Date date){
        return 0;
    }


}
