package com.dandan.other.design.strategy.singleton;

/**
 * @Description 懒汉式-线程不安全-lazy初始化
 * @Author dandan
 * @Date 2019-11-26
 */
public class Singleton01 {

    private static Singleton01 singleton = null;

    private Singleton01(){}

    public static Singleton01 getInstance(){
        if(singleton == null){
            singleton = new Singleton01();
        }
        return singleton;
    }

}
