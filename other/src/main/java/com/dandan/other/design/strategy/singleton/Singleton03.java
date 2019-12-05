package com.dandan.other.design.strategy.singleton;

/**
 * @Description 饿汉式-线程安全-空间换时间-效率高-非lazy初始化
 * @Author dandan
 * @Date 2019-11-26
 */
public class Singleton03 {

    private static final Singleton03 singleton = new Singleton03();

    private Singleton03(){}

    public static Singleton03 getInstance(){
        return singleton;
    }

}
