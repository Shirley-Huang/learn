package com.dandan.common.test;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by dandan On 九月 07 2019
 */
public class E implements InitializingBean {
    static {
        System.out.println("E----static method------");
    }

    public E(){
        System.out.println("E------construct method-------");
    }

    {
        System.out.println("E-------code method--------");
    }

    public void init(){
        System.out.println("E------init method-------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("E --afterPropertiesSet()------");
    }

}
