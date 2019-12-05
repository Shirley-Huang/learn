package com.dandan.other.base;

/**
 * @Description
 * @Author dandan
 * @Date 2019-11-21
 */
public class StringBuildAndStringBuffer extends StringB{

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();

        StringBuilder sbd = new StringBuilder("abcd1234");

        System.out.println(sbd.indexOf("2"));
        sbd.insert(4,"--");
        System.out.println(sbd.toString());


    }

}


/**
 * final class can not be inherit
 */
final class StringA{

}
class StringB{

}
