package com.dandan.other.generics;


import com.dandan.other.model.C;
import lombok.Data;
import org.junit.Test;

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

    @Test
    public void test() {
        Cat cat = new Cat();
        cat.setNote("this si problem");
        String note = "this is test";
        if(note != null){

            cat.setNote(note + ";" + cat.getNote() == null ? "" : cat.getNote());
        }
        System.out.println(cat.getNote());
//       Cat cat = new Cat();
//       cat.setName("lfs");
//       cat.setMobile("13472201613");
//       test01(cat);
//
//       List<Cat> cats = new ArrayList<>();
//       cats.add(cat);
//       test02(cats);
    }

    private void test02(List<Cat> cats) {

    }

    public void test01(Object value) {
        if(value instanceof Cat){
            Cat cat = (Cat) value;
            System.out.println(cat.getName() + "=" + cat.getMobile());
        }
    }




}
@Data
class Cat{
    private String name;
    private String mobile;
    private String note;

}
@Data
class Dog{
    private String name;
    private String mobile;

}