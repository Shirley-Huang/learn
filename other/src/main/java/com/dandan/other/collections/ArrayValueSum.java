package com.dandan.other.collections;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by dandan On 九月 27 2019
 */
public class ArrayValueSum {

    private static int[] o = {1,2,3,4,5,6,7,8,9,9,8,7,6,5,4,3,2,1,8,2};


    public static void main(String[] args) throws InterruptedException {

        int length = o.length;

        int times = length / 5;

        ArrayValueSum t = new ArrayValueSum();

        final int[] sum = {0};
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int finalI = i;
//            new Thread(()->t.m(finalI * 5, finalI * 5 + 5)).start();

            new Thread(new Runnable() {

                @Override
                public void run() {
                    sum[0] += m(finalI * 5,finalI * 5 + 5);
                }
            }).start();


        }
        System.out.println(System.currentTimeMillis() - startTime);

        TimeUnit.SECONDS.sleep(10);

        System.out.println(sum[0]);
    }


    public static int m(int start, int end){
        int sum = 0;
        for (int i = start; i < end ; i++) {
            sum += o[i];
        }
        return sum;
    }

    @Test
    public void testSum(){
        long startTime = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < o.length; i++) {
            sum += o[i];
        }
        System.out.println(System.currentTimeMillis() - startTime);

        System.out.println(sum);
    }




}
