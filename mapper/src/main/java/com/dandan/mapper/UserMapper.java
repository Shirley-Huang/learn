package com.dandan.mapper;

import com.dandan.model.filter.UserFilter;
import com.dandan.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dandan On 八月 24 2019
 */
@Mapper
public interface UserMapper {

    User selectUserById(@Param("id") Integer userId);

    List<User> selectAllUsers();

    List<Integer> selectUserIdsByFilter(@Param("filter") UserFilter filter);
    
    int countUsersByFilter(@Param("filter") UserFilter filter);

    void insertUser(User user);

    void batchInsertUser(@Param("users") List<User> users);

    void deleteUserById(@Param("userId") Integer userId);

    void updateUserById(User user);

    List<User> selectUserDefineColumn01();

    List<User> selectUserDefineColumn02();

}
