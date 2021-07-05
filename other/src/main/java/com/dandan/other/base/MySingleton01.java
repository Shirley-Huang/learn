package com.dandan.other.base;

/**
 * @Description
 * @Author dandan
 * @Date 2020/9/16
 */
public class MySingleton01 {

    private static MySingleton01 mySingleton = null;

    public MySingleton01 getInstance(){
        if(mySingleton == null){
            synchronized (mySingleton){
                if(mySingleton == null){
                    mySingleton = new MySingleton01();
                }
            }
        }
        return mySingleton;
    }



}
