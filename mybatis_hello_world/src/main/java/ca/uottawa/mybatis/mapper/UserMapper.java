package ca.uottawa.mybatis.mapper;

import ca.uottawa.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /**
     * 添加用户信息
     * @return int
     */
    int insertUser();

    /**
     * 修改用户信息
     * @return void
     */
    int updateUser();

    int deleteUser();

    User getUserById();

    List<User> getAllUsers();
}
