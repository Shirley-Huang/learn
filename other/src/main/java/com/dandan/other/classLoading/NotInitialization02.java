package com.dandan.other.classLoading;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-09
 */
public class NotInitialization02 {

    /**
     * 通过数组定义来引用类，不会出发此类的初始化
     * 触发的是另一个名为  Lcom.dandan.other.classLoading.SuperClass的类的初始化阶段，他是由虚拟机自动生成的、直接继承于Object的子类，创建动作由字节码指令newArrasy触发
     */
    public static void main(String[] args) {
        SuperClass[] sca = new SuperClass[10];
    }

}
