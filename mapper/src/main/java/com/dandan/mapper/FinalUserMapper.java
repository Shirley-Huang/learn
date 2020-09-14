package com.dandan.mapper;

import com.dandan.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-25
 */
@Mapper
public interface FinalUserMapper {

    void insertUser(User user);

    void batchInsertUser(@Param("users") List<User> users);

}
