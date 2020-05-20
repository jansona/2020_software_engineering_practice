package software.practice.distribution.service;

import javafx.util.Pair;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import software.practice.distribution.DistributionApplication;
import software.practice.distribution.entity.Package;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DistributionApplication.class)
public class PackageServiceTest {

    @Autowired
    PackageService packageService;

    @Test
    public void getPackages() {
        Pair<Long, List<Package>> pair = packageService.getPackages(1, 0,  null, "口罩", 1);
        Assert.assertEquals(pair.getValue().size(),3);
    }

    @Test
    public void addPackage() {
        Package p = new Package();
        p.setPackageUser(1);
        p.setPackageContent("十包薯片");
        Assert.assertEquals(packageService.addPackage(p),1);
    }

    @Test
    public void editPackage() {
        Package p = new Package();
        p.setPackageUser(1);
        p.setPackageContent("二包薯片");
        Assert.assertEquals(packageService.editPackage(p),true);
    }

    @Test
    public void removePackage() {
        Assert.assertEquals(packageService.removePackage(1),true);
    }

    @Test
    public void removePackages() {
        Integer[] ids = {1,2,3};
        Assert.assertEquals(packageService.removePackages(ids),true);
    }

    @Test
    public void writeFileToData() throws Exception{
        String strUrl = "F:\\物资.xls";
        File file = new File(strUrl);
        FileInputStream inputStream = new FileInputStream(file);
        MultipartFile multipartFile = new MockMultipartFile(file.getName(), inputStream);
        Pair<Boolean, String> pair = packageService.writeFileToData(multipartFile, "");
        Assert.assertEquals(pair.getKey(),true);
    }

    @Test
    public void getPackageCountByUser() {
        Map<String, Long> map = packageService.getPackageCountByUser(1);
        Assert.assertEquals(map.size(),6);
    }
}