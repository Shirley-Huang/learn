package com.dandan.other.base;


import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-03
 */
public class HashMapAndHashTable{

    public static void main(String[] args) {

//        HashMap map = new HashMap<String, String>();
//        map.put(null,null);


        Hashtable table = new Hashtable();
        table.put(null,"null");
        System.out.println(table.get(null));


    }

}
