package com.dandan.other.generics;


import com.dandan.other.model.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-22
 */
public class GenericsClass<T> {




   private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void test(String[] args) {
        Pet cat = new Cat();
        Dog dog = new Dog();
        List<? super Pet> petHouse = new ArrayList<>();
        petHouse.add(cat);
        List<? extends Pet> petHouse2 = new ArrayList<>();
        List<Pet> petHouse3 = new ArrayList<>();
        petHouse3.add(cat);
    }

    public void test01(String a){

    }

    public void test01(Integer i){

    }

    @Override
    public String toString() {
        return super.toString();
    }

    //    public String test01(String a){     error 仅返回值不同非重载方法
//    }

}
class Pet{

}
class Cat extends Pet{

}
class Dog extends Pet{

}