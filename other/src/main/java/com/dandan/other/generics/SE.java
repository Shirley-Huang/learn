package com.dandan.other.generics;

import com.dandan.other.generics.contains.MyMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-22
 */
public class SE {

    public static void main(String[] args) {

       Map map = new HashMap();
       map.put("2","3");

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        System.out.println(iterator.next());
    }

}
