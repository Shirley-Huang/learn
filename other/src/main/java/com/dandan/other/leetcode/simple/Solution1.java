package com.dandan.other.leetcode.simple;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 989. 数组形式的整数加法
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 *
 * 示例 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 *
 * 示例 3：
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 *
 * 示例 4：
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 *
 * @Date 2021/1/25
 */
public class Solution1 {

    public static List<Integer> addToArrayForm0(int[] A, int K) {
        List<Integer> B = new ArrayList<>();
        for(int i = A.length - 1; i >= 0; i--){
            int num = A[i] + (K % 10);
            K /= 10;
            if(num >= 10){
                K++;
            }
            B.add(num % 10);
        }

        while (K > 0){
            B.add(K % 10);
            K /= 10;
        }

        Collections.reverse(B);
        return B;
    }


    public static List<Integer> addToArrayForm1(int[] A, int K) {
        ArrayList<Integer> B = new ArrayList();
        int num = K, i = 0;
        while (num > 0){
            B.add(num % 10);
            num /= 10;
        }

        LinkedList<Integer> C = new LinkedList<>();
        int length = B.size() <= A.length ? B.size() : A.length;
        Boolean addFlow = false;
        for(i = 0; i < length; i++){
            int temp = B.get(i) + A[A.length - 1 - i] + (addFlow ? 1 : 0);
            if(temp >= 10){
                addFlow = true;
                C.addFirst(temp % 10);
            }else{
                addFlow = false;
                C.addFirst(temp);
            }
        }

        int length2 = A.length > B.size() ? A.length : B.size();
        boolean isA = A.length > B.size() ? true : false;
        for(;i < length2 && length2 > length; i++){
            int temp = (isA ? A[A.length - 1 -i] : B.get(i)) + (addFlow ? 1 : 0);
            if(temp >= 10){
                addFlow = true;
                C.addFirst(temp % 10);
            }else{
                addFlow = false;
                C.addFirst(temp);
            }
        }
        if(addFlow){
            C.addFirst(1);
        }
        return C;
    }

    public List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> res = new ArrayList<Integer>();
        int n = A.length;
        for (int i = n - 1; i >= 0; --i) {
            int sum = A[i] + K % 10;
            K /= 10;
            if (sum >= 10) {
                K++;
                sum -= 10;
            }
            res.add(sum);
        }
        for (; K > 0; K /= 10) {
            res.add(K % 10);
        }
        Collections.reverse(res);
        return res;
    }

}
