package com.dandan.other.spring.aop.test;

import com.dandan.other.spring.aop.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-16
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/service-aop.xml")
public class MyServiceImplTest {
    @Autowired
    private MyService myService;


    @Test
    public void createOrder(){
//        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/service-aop.xml");
//        MyService service = (MyService)applicationContext.getBean("myService");
        String result = myService.createOrder("100100", "黄丹丹");
        System.out.println(result);
    }

}
