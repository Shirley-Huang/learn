package com.dandan.other.classLoading;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-09
 */
public class NotInitialization01 {

    /**
     * 通过子类引用父类的静态字段，不会导致子类的初始化
     */

    public static void main(String[] args) {
        int a = SubClass.value;
    }

}

class SuperClass{
    static {
        System.out.println("SuperClass init");
    }
    public static int value = 123;
    public static final String CONST_VAR = "hellow world";
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }
}
