package com.dandan.service.controller;

import com.dandan.service.model.UserInfo;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description
 * '@EnableAutoConfiguration'  启用SpringBoot自动装配
 * 开启spring应用程序的自动配置，自动配置根据你引入的web启动器来猜测并进行web、springMVC的默认配置
 * 引入了对应库所需的依赖，springboot对第三方库或spring内部库进行的默认配置就会生效
 * @Author dandan
 * @Date 2020/8/31
 */

@RestController
//@EnableAutoConfiguration
public class UserController {

    @RequestMapping("/login")
    public void login(){

    }

    @GetMapping("/test")
    public String test(@RequestParam(value = "name", defaultValue = "Dandan") String name){
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        return String.format("Spring Boot is started in %tF %tT  /  %s  / %s", now, now, format.format(now),name);
    }
    @GetMapping("/get")
    public UserInfo getUserInfo(){
        UserInfo userInfo = new UserInfo();
        userInfo.name = "HuangDan_dan";
        userInfo.age = 22;
        userInfo.female = true;
        return userInfo;
    }

    /**
     * 启动方法1
     */
    public static void main(String[] args){
        SpringApplication.run(UserController.class);
    }

}
