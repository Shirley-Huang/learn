package com.dandan.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by dandan On 八月 27 2019
 */
public class OrderLogisticsMapperTest {

    @Test
    public void clearOrderCache() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = factory.openSession();
        List<String> orderIds = sqlSession.selectList("selectOrderIds");
        for (String orderId : orderIds) {
            try {
                clearCache(orderId);
            } catch (Exception e) {
                System.out.println(orderId + " 清除缓存失败");
            }
        }


    }

    public void clearCache(String orderId) throws Exception {

    }

}
