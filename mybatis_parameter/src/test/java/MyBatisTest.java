import ca.uottawa.mybatis.mapper.UserMapper;
import ca.uottawa.mybatis.pojo.User;
import ca.uottawa.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;


public class MyBatisTest{


    @Test
    public void checkLoginByMap(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("username", "ybc");
        map.put("password", "123");
        User result = mapper.checkLoginByMap(map);
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void findUserById(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User result = mapper.findUserById(1);
        System.out.println(result);
        sqlSession.close();
    }

    @Test
    public void insertUser(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(null, "eqw","3456",45,"ansdf","234453@gmail.com");
        mapper.insertUser(user);
        System.out.println(user);

    }
}
