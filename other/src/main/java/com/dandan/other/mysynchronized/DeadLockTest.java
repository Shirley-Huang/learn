package com.dandan.other.mysynchronized;

/**
 * Created by dandan On 九月 26 2019
 */
public class DeadLockTest {

    public static Object o1 = new Object();
    public static Object o2 = new Object();


    public static void main(String[] args) throws Exception{

        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();

    }



}
