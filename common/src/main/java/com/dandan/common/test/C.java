package com.dandan.common.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by dandan On 九月 07 2019
 */
public class C implements BeanPostProcessor, InitializingBean {

    static {
        System.out.println("C----static method------");
    }

    public C(){
        System.out.println("C------construct method-------");
    }

    {
        System.out.println("C-------code method--------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("C--afterPropertiesSet()---------");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("C--postProcessBeforeInitialization() -------"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("C----postProcessAfterInitialization()--------"+beanName);
        return bean;
    }

    public void init(){
        System.out.println("C------init method-------");
    }

}
