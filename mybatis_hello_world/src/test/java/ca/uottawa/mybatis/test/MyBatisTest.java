package ca.uottawa.mybatis.test;

import ca.uottawa.mybatis.mapper.UserMapper;
import ca.uottawa.mybatis.pojo.User;
import ca.uottawa.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.io.IOException;
import java.util.List;

public class MyBatisTest{

    @Test
    public void testInsert() throws IOException{
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class); // 代理模式, 实现类
        int result = mapper.insertUser();
        System.out.println(result);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdate(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int result = mapper.updateUser();
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void testSelect(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User result = mapper.getUserById();
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void selectAllUsers(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> result = mapper.getAllUsers();
        result.forEach(System.out::println);
        sqlSession.close();
    }
}
