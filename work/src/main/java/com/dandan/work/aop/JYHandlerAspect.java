package com.dandan.work.aop;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @Description
 * @Author dandan
 * @Date 2020/10/30
 */
@Aspect
public class JYHandlerAspect {

    @Before("execution(* com.dandan.work.handler.JYHandlerImpl.clearOrderCache(..))")
    public void startStaticDate(){
        System.out.println("发起请求");
    }

    @AfterReturning("execution(* com.dandan.work.handler.JYHandlerImpl.clearOrderCache(..))")
    public void staticData(){
        System.out.println("统计数据");
    }

}
