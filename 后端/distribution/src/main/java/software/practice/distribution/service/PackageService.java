package software.practice.distribution.service;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.practice.distribution.entity.Package;
import software.practice.distribution.entity.PackageExample;
import software.practice.distribution.mapper.PackageMapper;

import java.util.List;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/15 下午 5:55
 * @description ：
 */
@Service
public class PackageService {
    @Autowired
    PackageMapper packageMapper;

    public List<Package> getPackages(int page, int id, int user, String content){
        PackageExample example = new PackageExample();
        PackageExample.Criteria criteria = example.createCriteria();
        if(id != 0){
            criteria.andPackageIdEqualTo(id);
        }
        else if(user != 0){
            criteria.andPackageUserEqualTo(user);
        }
        if (content != null){
            criteria.andPackageContentLike("%"+content+"%");
        }

        return packageMapper.selectByExampleWithRowbounds(example,new RowBounds((page-1)*10,10));
    }
}
