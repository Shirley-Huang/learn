package com.dandan.other.sort;

import java.util.Arrays;

/**
 * @Description
 * @Author dandan
 * @Date 2019-11-29
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {49,38,65,97,76,13,27,49,55,04};
        System.out.println("sorting:" + Arrays.toString(arr));
        //selectionSort(arr);
        //bubble(arr);
        quickSort(arr,0,arr.length - 1);

        Arrays.sort(arr);
    }

    /**
     * 选择排序，在未排序序列中找到最小（大）元素，存放到未排序序列的起始位置
     */
    public static void selectionSort(int[] arr){
        System.out.println("选择排序");

        for (int i = 0; i < arr.length - 1; i++){
            int k = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[k]){
                    k = j;
                }
            }
            if(k != i){
                int tmp = arr[k];
                arr[k] = arr[i];
                arr[i] = tmp;
                System.out.println("sorting" + Arrays.toString(arr));
            }
        }

    }

    public static void bubble(int[] arr){

        System.out.println("冒泡排序");
        for(int i = arr.length - 1; i > 0; i--){
            for(int j = 0; j < i ; j++){
                if(arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
            System.out.println("sorting" + Arrays.toString(arr));
        }
    }

    public static void quickSort(int[] arr, int low, int high){
        if(arr.length <= 0) {
            return;
        }
        if(low >= high){
            return;
        }

        System.out.println("快速排序");

        int left = low;
        int right = high;
        int tmp = arr[left];

        while (left < right){
            while (left < right && arr[right] >= tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        System.out.println("sorting:" + Arrays.toString(arr));
        quickSort(arr,low,left - 1);
        quickSort(arr,left + 1, high);

    }

}
