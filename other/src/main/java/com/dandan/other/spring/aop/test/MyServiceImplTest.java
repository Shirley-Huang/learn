package com.dandan.other.spring.aop.test;

import com.dandan.other.spring.aop.service.MyService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-16
 */

public class MyServiceImplTest {



    @Test
    public void createOrder(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/service-aop.xml");
        MyService service = (MyService)applicationContext.getBean("myService");
        String result = service.createOrder("100100", "黄丹丹");
        System.out.println(result);
    }

}
