package com.dandan.mapper.test;


import com.dandan.mapper.UserMapper;
import org.apache.ibatis.datasource.jndi.JndiDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;

/**
 * Created by dandan On 八月 24 2019
 */
public class MybatisConfiguration03 {


    public static void main(String[] args) {

        //dataSource is null
        DataSource dataSource = new JndiDataSourceFactory().getDataSource();

        TransactionFactory jdbcTransactionFactory = new JdbcTransactionFactory();

        Environment environment = new Environment("development",jdbcTransactionFactory,dataSource);

        Configuration configuration = new Configuration(environment);
        configuration.addMapper(UserMapper.class);

        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
        System.out.println(sqlSessionFactory.openSession());


    }

}
