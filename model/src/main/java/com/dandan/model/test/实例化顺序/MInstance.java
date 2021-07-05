package com.dandan.model.test.实例化顺序;

/**
 * @Description
 * @Author dandan
 * @Date 2020/10/14
 */
public class MInstance {

    MInstance2 mInstance2 = new MInstance2();

    static {
        System.out.println("MInstance----静态代码块");
    }

    {
        System.out.println("MInstance----代码块");
    }

    public MInstance(){
        System.out.println("MInstance----构造方法");
    }

}
