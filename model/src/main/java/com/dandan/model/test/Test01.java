package com.dandan.model.test;

/**
 * Created by dandan On 八月 28 2019
 */
public class Test01 {

    static {
        System.out.println("静态代码块");
    }

    {
        System.out.println("代码块");
    }

    public Test01(){
        System.out.println("构造方法");
    }

}
