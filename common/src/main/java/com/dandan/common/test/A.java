package com.dandan.common.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by dandan On 九月 07 2019
 */
public class A implements BeanPostProcessor, InitializingBean, ApplicationContextAware {

    static {
        System.out.println("A----static method------");
    }

    public A(){
        System.out.println("A------construct method-------");
    }

    {
        System.out.println("A-------code method--------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("A--afterPropertiesSet()---------");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("A--postProcessBeforeInitialization() -------"+beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("A----postProcessAfterInitialization()--------"+beanName);
        return bean;
    }

    public void init(){
        System.out.println("A------init method-------");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        System.out.println("A setApplicationContext()" + applicationContext.getDisplayName());
    }

}
