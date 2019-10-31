package com.dandan.common.test;

import org.springframework.beans.factory.InitializingBean;

/**
 * Created by dandan On 九月 07 2019
 */
public class D implements InitializingBean {
    static {
        System.out.println("D----static method------");
    }

    public D(){
        System.out.println("D------construct method-------");
    }

    {
        System.out.println("D-------code method--------");
    }

    public void init(){
        System.out.println("D------init method-------");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("D-----afterPropertiesSet()-----");
    }

}
