package com.dandan.mapper;

import com.dandan.model.filter.UserFilter;
import com.dandan.model.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dandan On 八月 24 2019
 */
public interface UserMapper {

    User selectUserById(@Param("userId") Integer userId);

    List<User> selectAllUsers();

    List<Integer> selectUserIdsByFilter(@Param("filter") UserFilter filter);
    
    int countUsersByFilter(@Param("filter") UserFilter filter);

}
