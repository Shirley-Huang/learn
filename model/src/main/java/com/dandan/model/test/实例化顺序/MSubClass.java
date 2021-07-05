package com.dandan.model.test.实例化顺序;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Created by dandan On 八月 28 2019
 */
public class MSubClass extends MSuperClass {



    static {
        System.out.println("MSubClass----静态代码块");
    }

    {
        System.out.println("MSubClass----代码块");
    }

    public MSubClass(){
        System.out.println("MSubClass----构造方法");
    }

    public static void main(String[] args) {
        //MSubClass subClass = new MSubClass();
        HashMap<String,Integer> map = new HashMap<>();


        System.out.println(map.get("aa"));
    }

}
