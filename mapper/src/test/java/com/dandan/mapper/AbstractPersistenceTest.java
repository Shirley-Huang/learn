package com.dandan.mapper;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dandan On 八月 25 2019
 */
//@RunWith(JUnit4.class)  //指用JUnit4这个运行器来运行
@RunWith(SpringJUnit4ClassRunner.class) //测试运行于Spring测试环境
@ContextConfiguration(locations = "classpath:spring/spring-mybatis.xml")
public abstract class AbstractPersistenceTest {

}
