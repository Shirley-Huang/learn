package com.dandan.mapper;
import java.util.List;

import com.dandan.model.test.User2;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by dandan On 九月 21 2019
 */
@Mapper
public interface User2Mapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    int insertSelective(User2 record);

    User2 selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);


    List<User2> findByUserNameAndPassword(@Param("userName")String userName,@Param("password")String password);







}