package com.dandan.model.test.实例化顺序;

/**
 * Created by dandan On 八月 28 2019
 *
 */
public class MSuperClass {

    MInstance mInstance = new MInstance();

    static {
        System.out.println("MSuperClass----静态代码块");
    }

    {
        System.out.println("MSuperClass----代码块");
    }

    public MSuperClass(){
        System.out.println("MSuperClass----构造方法");
    }

}
