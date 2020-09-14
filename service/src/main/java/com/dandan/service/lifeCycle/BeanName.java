package com.dandan.service.lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
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
public class BeanName implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

    private static final String CLASS_NAME = BeanName.class.getName();

//    private final DIBeanName diBeanName;
//
//    public BeanName(@Autowired DIBeanName diBeanName){
//        this.diBeanName = diBeanName;
//        System.out.println(CLASS_NAME + "------构造方法");
//    }

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

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

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName + "------BeanPostProcessor-postProcessorBeforeInitialization()");
        return null;
    }

    @PostConstruct
    public void postConstructMethod(){
        System.out.println(CLASS_NAME + "------@PostConstruct注解方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(CLASS_NAME + "------InitializingBean-afterPropertiesSet()");
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println(beanName + "------BeanPostProcessor-postProcessorAfterInitialization()");
        return null;
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
