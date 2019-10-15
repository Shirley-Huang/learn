package com.dandan.mapper;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by dandan On 九月 21 2019
 */
public class User2MapperTest {

    private static User2Mapper mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(User2MapperTest.class.getClassLoader().getResourceAsStream("spring/spring-mybatis.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(User2Mapper.class, builder.openSession(true));
    }

    @Test
    public void testFindByUserNameAndPassword() throws FileNotFoundException {
        mapper.findByUserNameAndPassword("", "");
    }

    @Test
    public void testUpdateByPrimaryKey() throws FileNotFoundException {
//        mapper.updateByPrimaryKey();
    }




}
