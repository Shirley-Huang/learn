package com.dandan.mapper;

import com.dandan.model.enums.SexType;
import com.dandan.model.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
public class FinalUserMapperTest{


    @Autowired
    private FinalUserMapper userMapper;


    @Test
    public void batchInsertInfos() throws Exception{
        User user = new User();
        user.setUserName("凤山");
        user.setPassword("abcd1234");
        user.setMobile("13473301613");
        user.setAge(25);
        user.setSex(SexType.M);

        List<User> users = new ArrayList<>();
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
        users.add(user);
//

//        userMapper.insertUser(user);
//        System.out.println(user.getId());

        userMapper.batchInsertUser(users);
        for (User user1 : users) {
            System.out.println(user1.getId());
        }



    }



}
