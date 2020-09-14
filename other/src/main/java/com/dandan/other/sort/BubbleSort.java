package com.dandan.other.sort;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @Description
 * @Author dandan
 * @Date 2020/6/12
 */
public class BubbleSort {

    @Test
    public void bubble(){
        int[] a = new int[]{7,6,9,1,4,2,5};
        displayArray(a);
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if(a[j] < a[i]){

                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
            displayArray(a);
        }

    }

    private void displayArray(int[] a){
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    @Test
    public void test(){
        BigDecimal a = new BigDecimal(120);
        System.out.println(a.setScale(2).toString());
    }

}
