package com.dandan.other.classLoading;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-09
 */
public class NotInitialization03 {

    /**
     * 常量在编译阶段会存入调用类的常量池，本质上没有直接引用到定义常量到类，因此不会出发定义常量的类的初始化
     */

    public static void main(String[] args) {
        String constVar = SuperClass.CONST_VAR;
    }

}
