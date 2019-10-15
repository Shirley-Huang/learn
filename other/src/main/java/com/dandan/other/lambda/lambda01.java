package com.dandan.other.lambda;

import org.junit.Test;

import java.util.*;

/**
 * Created by dandan On 十月 11 2019
 */
public class lambda01 {

    @Test
    public void lambdaExpress(){


        List<String> lists = new ArrayList<String>();
        lists.add("1");
        lists.add("a");

        //遍历list集合
        lists.forEach(list -> System.out.println(list));

        Map<String,Object> map = new HashMap<>();
        map.put("1","a");
        //遍历map集合
        map.forEach((key,value) -> System.out.println(key+value));


        Comparator c1 = new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };

        Comparator c2 = (o1, o2) -> {
            return 1;
        };

        Comparator<Integer> c3 = Integer::compare;


//        System.out.println(c1.compare(4,5));
//        System.out.println(c2.compare(2,3));
//        System.out.println(c3.compare(9,2));
    }

}
