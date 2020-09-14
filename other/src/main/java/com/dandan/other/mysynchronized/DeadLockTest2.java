package com.dandan.other.mysynchronized;

/**
 * Created by dandan On 九月 26 2019
 */
public class DeadLockTest2 {

    private Object o1 = new Object();
    private Object o2 = new Object();

    public synchronized void m1() throws InterruptedException {
        synchronized (o1){
            System.out.println("m1 start-----");
            Thread.sleep(5000);
            synchronized (o2) {
                m2();
            }
            System.out.println("m2 end------");
        }
    }

    public synchronized void m2() throws InterruptedException {
        synchronized (o2){
            System.out.println("m2 start-----");
            Thread.sleep(10000);
            synchronized (o1){
                m1();
            }
            System.out.println("m2 end------");
        }
    }

    public static void main(String[] args) throws Exception{
        DeadLockTest2 lock = new DeadLockTest2();

        new Thread(()-> {
            try {
                lock.m1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()-> {
            try {
                lock.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("kdk");
    }



}
