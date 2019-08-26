package com.dandan.mapper.test;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by dandan On 八月 24 2019
 */
public class MybatisConfiguration01 {

    public static void main(String[] args) {
        //加载配置文件
        try {
            String fileName = "mybatis-config.xml";
            //获取类对象、获取类加载器、获取资源文件【getClassLoader（）从当前类所在包开始找，没有则从当前类所在文件下开始找】
            InputStream inputStream = MybatisConfiguration01.class.getClassLoader().getResourceAsStream(fileName);
            //构建会话工厂
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开会话
            System.out.println(factory.openSession());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
