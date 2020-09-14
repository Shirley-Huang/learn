package com.dandan.other.base;

import java.util.Scanner;

/**
 * @Description 将字符串转换为int类型
 * @Author dandan
 * @Date 2019-11-14
 */
public class StringToInteger {

    public static void main(String[] args) {

//        String str = new Scanner(System.in).next();
        String str = "123";
        int digit = Integer.parseInt(str);
        System.out.println(digit);

    }

}
