package com.dandan.model.test.实例化顺序;

/**
 * @Description
 * @Author dandan
 * @Date 2020/10/14
 */
public class MInstance2 {

    static {
        System.out.println("MInstance2----静态代码块");
    }

    {
        System.out.println("MInstance2----代码块");
    }

    public MInstance2(){
        System.out.println("MInstance2----构造方法");
    }

}
