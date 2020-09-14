package com.dandan.mapper;

import com.dandan.model.enums.SexType;
import com.dandan.model.filter.UserFilter;
import com.dandan.model.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dandan On 八月 25 2019
 */
public class UserMapperTest{

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
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
//        User user = sqlSession.selectOne("selectUserById",1);
//        System.out.println(user.getSex().getDescription());
//        System.out.println(user);

        System.out.println("--------------------");
        UserFilter filter = new UserFilter();
        filter.setKeyword("17600903965");
//        List<Integer> userIds = sqlSession.selectList("selectUserIdsByFilter",filter);
//        System.out.println(userIds.toArray());
//        List<User> users= sqlSession.selectList("selectAllUsers");
//        System.out.println(users.toString());

        User user = new User();
        user.setUserName("凤山");
        user.setPassword("abcd1234");
        user.setMobile("13473301613");
        user.setAge(25);
        user.setSex(SexType.M);
        //sqlSession.insert("insertUser",user);

        //sqlSession.delete("deleteUserById",7);

        sqlSession.selectList("selectUserDefineColumn02");

        //sqlSession.commit();
        System.out.println(user.getId());

        if(sqlSession != null){
            sqlSession.close();
        }

    }

    @Test
    public void secondLevelCache() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        SqlSession sqlSession3 = sqlSessionFactory.openSession();
        SqlSession sqlSession4 = sqlSessionFactory.openSession();
        // 创建代理对象
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        // 第一次发起请求，查询id为1的用户
        User user1 = userMapper1.selectUserById(1);
        System.out.println(user1);
        //这里执行关闭操作，将sqlsession中的数据写到二级缓存区域
        sqlSession1.close();

        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        // 第二次发起请求，查询id为1的用户
        User user2 = userMapper2.selectUserById(1);
        System.out.println(user2);

        sqlSession2.close();

        //sqlSession3用来清空缓存的，如果要测试二级缓存，需要把该部分注释掉
        //使用sqlSession3执行commit()操作
        UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
        User user  = userMapper3.selectUserById(1);
        user.setUserName("Shirley");
        userMapper3.updateUserById(user);
        //执行提交，清空UserMapper下边的二级缓存
        sqlSession3.commit();
        sqlSession3.close();

        UserMapper userMapper4 = sqlSession4.getMapper(UserMapper.class);
        // 第二次发起请求，查询id为1的用户
        User user4 = userMapper4.selectUserById(1);
        System.out.println(user4);

        sqlSession4.close();


    }

}
