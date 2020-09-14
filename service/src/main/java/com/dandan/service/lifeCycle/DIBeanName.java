package com.dandan.service.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Description
 * @Author dandan
 * @Date 2020/9/4
 */
@Component
public class DIBeanName implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private static final String CLASS_NAME = DIBeanName.class.getName();


    @Override
    public void setBeanName(String s) {
        System.out.println(CLASS_NAME + "------BeanNameAware-setBeanName()");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(CLASS_NAME + "------BeanFactoryAware-setBeanFactory()");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(CLASS_NAME + "------ApplicationContextAware-setApplicationContext()");
    }


    @PostConstruct
    public void postConstructMethod(){
        System.out.println(CLASS_NAME + "------@PostConstruct注解方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(CLASS_NAME + "------InitializingBean-afterPropertiesSet()");
    }


    @PreDestroy
    public void preDestroyMethod(){
        System.out.println(CLASS_NAME + "------@PreDestroy注解方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println(CLASS_NAME + "------DisposableBean-destroy()");
    }

}
