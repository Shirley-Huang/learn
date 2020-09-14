package com.dandan.service;

import com.dandan.service.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Description
 * @Author dandan
 * @Date 2020/8/31
 */
//@ComponentScan
//@EnableAutoConfiguration
public class ApplicationTest {

    /**
     * 启动方法2 -使用注解扫描
     */
    public static void main(String[] args) {
        SpringApplication.run(UserController.class);
    }

}
