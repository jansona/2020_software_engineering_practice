package software.practice.distribution;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.mock.web.MockMultipartFile;
import software.practice.distribution.service.DealService;
import software.practice.distribution.service.PackageService;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
class DistributionApplicationTests {

    @Autowired
    DealService dealService;
    PackageService packageService;

    @Test
    void contextLoads() {

    }

    @Test
    void loadFile()throws Exception {


    }
}
