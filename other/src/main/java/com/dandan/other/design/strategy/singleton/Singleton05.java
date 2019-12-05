package com.dandan.other.design.strategy.singleton;

/**
 * @Description 登记式/静态内部类-线程安全-lazy初始化-静态域
 * @Author dandan
 * @Date 2019-11-26
 */
public class Singleton05 {

    private static class SingletonHolder{
        private static final Singleton05 INSTANCE = new Singleton05();
    }

    private Singleton05(){}

    public static final Singleton05 getInstance(){
        return SingletonHolder.INSTANCE;
    }

}
