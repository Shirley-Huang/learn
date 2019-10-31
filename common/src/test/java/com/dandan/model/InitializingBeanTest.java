package com.dandan.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.ObjectUtils;

/**
 * Created by dandan On 八月 25 2019
 */
public class InitializingBeanTest {

    /**
     * Spring为bean提供了两种初始化bean的方式，实现InitializingBean接口重写afterPropertiesSet方法，
     * 或者在配置文件bean标签中添加init-method属性，指定初始化方法
     *
     * 通过反射调用init-method指定的方法效率没有afterPropertiesSet方法高，但init-method消除了对spring的依赖
     *
     * 如果afterPropertiesSet方法时出错，则不调用init-method指定的方法
     *
     * InitializingBean接口为bean提供了初始化方法的方式，只包含afterPropertiesSet方法，
     * 凡是继承该接口的类，在初始化bean的时候执行该方法
     *
     * 如果该类在定义的配置文件中，bean标签使用init-method属性，先执行afterPropertiesSet方法再执行init-method方法
     *
     */

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/testBeanInit.xml");
    }

}
