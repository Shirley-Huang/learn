package com.dandan.other.design.strategy.singleton;

/**
 * @Description 懒汉模式-线程安全-效率较低-lazy初始化
 * @Author dandan
 * @Date 2019-11-26
 */
public class Singleton02 {

    private static Singleton02 singleton;

    private Singleton02(){}

    public static synchronized Singleton02 getInstance(){
        if(singleton == null){
            singleton = new Singleton02();
        }
        return singleton;
    }

}
