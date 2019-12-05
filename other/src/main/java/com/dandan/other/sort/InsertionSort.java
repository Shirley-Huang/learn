package com.dandan.other.sort;

import java.util.Arrays;

/**
 * @Description 插入排序 原理：往有序的数组中快速插入一个新的元素
 * @Author dandan
 * @Date 2019-11-27
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49,55,04};
        System.out.println("sorting:" + Arrays.toString(arr));
        directInsertionSort(arr);
        shellSort(arr);
    }


    /**
     * 直接插入排序
     * 基本思路：将数组中的所有元素依次跟前面已经排好的元素相比较，如果选择的元素比已排序的元素小则交换，直到全部元素都比较过为止
     * 具体算法：1、从第一个元素开始，该元素可以认为已经被排序  2、取出下一个元素，在已经排序的元素序列中从后向前扫描
     *  3、如果已排序的元素大于新元素，将该元素移到下一位置  4、找到新元素的位置，将新元素插入到该位置
     */
    public static void directInsertionSort(int[] arr){
        System.out.println("直接插入排序");
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int tmp = arr[j];
            for (; j > 0; j--) {
               if(arr[j - 1] <= tmp){
                   break;
               }
               arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
            System.out.println("sorting:" + Arrays.toString(arr));
        }
    }


    /**
     * 折半插入排序（二分插入排序）
     */

    /**
     * 链表插入排序
     */

    /**
     * 希尔排序-递减增量排序
     */
    public static void shellSort(int[] arr){
        System.out.println("希尔排序");
        int N = arr.length;

        //不断缩小gap知道1为止
        for (int gap = N / 2; gap > 0; gap /= 2){

            for(int i = gap; i < N; i++){
                int tmp = arr[i];
                int j = i - gap;
                for(; j >= 0; j -= gap){
                    if(arr[j] <= tmp){
                        break;
                    }
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = tmp;
            }

            System.out.println("sorting:" + Arrays.toString(arr));
        }
    }

}
























