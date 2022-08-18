package ca.uottawa.mybatis.mapper;

import ca.uottawa.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    User checkLoginByMap(Map<String, Object> map);

    User findUserById(@Param("id") Integer id);

    List<User> findUserByFuzzyQuery(@Param("") String query);

    void insertUser(User user);
}
