package com.dandan.common.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by dandan On 九月 07 2019
 */
public class B implements BeanPostProcessor, InitializingBean {

    static {
        System.out.println("B----static method------");
    }

    public B(){
        System.out.println("B------construct method-------");
    }

    {
        System.out.println("B-------code method--------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("B--afterPropertiesSet()---------");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("B--postProcessBeforeInitialization() -------"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("B----postProcessAfterInitialization()--------"+beanName);
        return bean;
    }

    public void init(){
        System.out.println("B------init method-------");
    }

}
