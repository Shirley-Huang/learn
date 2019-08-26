package com.dandan.mapper;

import com.dandan.model.filter.UserFilter;
import com.dandan.model.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dandan On 八月 25 2019
 */
public class UserMapperTest extends AbstractPersistenceTest{

//    @Autowired
//    private UserMapper userMapper;
//
//    public void selectUserById(){
//        Integer userId = 1;
//        User user = userMapper.selectUserById(userId);
//        System.out.println(user);
//    }

    @Test
    public void selectUserById2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("selectUserById",1);
        System.out.println(user);

        System.out.println("--------------------");
        UserFilter filter = new UserFilter();
        filter.setKeyword("17600903965");
//        List<Integer> userIds = sqlSession.selectList("selectUserIdsByFilter",filter);
//        System.out.println(userIds.toArray());
        List<User> users= sqlSession.selectList("selectAllUsers");
        System.out.println(users.toString());
    }



}
