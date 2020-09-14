package com.dandan.other.mysynchronized;

/**
 * Created by dandan On 九月 27 2019
 */
public class Lock1 implements Runnable{

    @Override
    public void run() {

        try{
            System.out.println("Lock1 running");
            while (true){
                synchronized (DeadLockTest.o1){
                    System.out.println("Lock1 lock o1");
                    Thread.sleep(3000);
                    synchronized (DeadLockTest.o2){
                        System.out.println("Lock1 lock 02");
                    }
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
