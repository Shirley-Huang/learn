package com.dandan.other.design.strategy.singleton;

/**
 * @Description 双重校验锁-线程安全-高性能-lazy初始化-实例域
 * @Author dandan
 * @Date 2019-11-26
 */
public class Singleton04 {

    private static Singleton04 singleton;

    private Singleton04(){}

    public static Singleton04 getInstance(){
        if(singleton == null){
            synchronized (Singleton04.class){
                if(singleton == null){
                    singleton = new Singleton04();
                }
            }
        }
        return singleton;
    }

}
