package com.dandan.other.io;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author dandan
 * @Date 2021/3/3
 */
public class Test {

    public static void main(String[ ] args) {

        String a1 = "hahah";
        String a2 = "你和";
        System.out.println();

//        Test t=new Test();
//        Integer integer = 100;
//        int num = integer.intValue();

    }

    @org.junit.Test
    public void test(){
        String pattern = "^LK(JL00|CQ00|BJ00)[0-9]{2}$";
//        String pattern = "^LKJL001[0-9]{2}$";
        Pattern rule = Pattern.compile(pattern);
        String a = "LKJL00121";
        Matcher matcher = rule.matcher(a);
        boolean b = matcher.find();
        System.out.println(b);
    }

//    @org.junit.Test
//    public void test() {
//        int i = 40;
//        int i0 = 40;
//        Integer i1 = 40;
//        Integer i2 = 40;
//        Integer i3 = 0;
//        Integer i4 = new Integer(40);
//        Integer i5 = new Integer(40);
//        Integer i6 = new Integer(0);
//        Double d1=1.0;
//        Double d2=1.0;
//
//        System.out.println("i=i0\t" + (i == i0));
//        System.out.println("i1=i2\t" + (i1 == i2));
//        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
//        System.out.println("i4=i5\t" + (i4 == i5));
//        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));
//        System.out.println("d1=d2\t" + (d1==d2));
//
//        System.out.println();
//    }
//
//    @org.junit.Test
//    public void test022(){
//        System.out.println(Math.pow(2, 14));
//    }

}
