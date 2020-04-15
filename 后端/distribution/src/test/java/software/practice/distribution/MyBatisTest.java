package software.practice.distribution;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import software.practice.distribution.entity.User;
import software.practice.distribution.mapper.UserMapper;

import java.io.InputStream;
import java.util.Date;

/**
 * @author ：Chang Jiaxin
 * @date ：Created in 2020/4/14 下午 4:41
 * @description ： 测试
 */
public class MyBatisTest {
    private InputStream in;
    private SqlSession session;
    private UserMapper userMapper;

    @Before
    public void init() throws Exception{
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        session = factory.openSession();
        userMapper = session.getMapper(UserMapper.class);
    }

    @After
    public void destroy() throws Exception{
        session.close();
        in.close();
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setUserName("李四");
        user.setUserAddress("2号楼301");
        Date time = new Date();
        user.setUserFavoriteStarttime(time);
        user.setUserTimeStay(3600);
        userMapper.insertSelective(user);
        session.commit();
    }

    @Test
    public void testFindById(){
        User user = userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }
}
