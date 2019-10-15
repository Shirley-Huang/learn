package com.dandan.test.mysynchronized;

/**
 * Created by dandan On 九月 27 2019
 */
public class Lock2 implements Runnable{

    @Override
    public void run() {

        try{
            System.out.println("Lock2 running");
            while (true){
                synchronized (DeadLockTest.o2){
                    System.out.println("Lock2 lock o2");
                    Thread.sleep(3000);
                    synchronized (DeadLockTest.o1){
                        System.out.println("Lock2 lock 01");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
