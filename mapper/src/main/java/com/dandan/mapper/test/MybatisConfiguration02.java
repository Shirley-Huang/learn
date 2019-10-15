package com.dandan.mapper.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by dandan On 八月 24 2019
 */
public class MybatisConfiguration02 {

    public static void main(String[] args) {
        String fileName = "mybatis/mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(fileName);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            System.out.println(sqlSessionFactory.openSession());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
