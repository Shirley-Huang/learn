package com.dandan.other.base;

import org.junit.Test;

import java.util.Date;

/**
 * @Description
 * @Author dandan
 * @Date 2020/7/2
 */
public class MyObject<T> {

    @Test
    public void test() throws Exception {
        A a = new A();
        a.var1 = "333";
        a.var2 = 1;
        A b = (A)a.clone();
        System.out.println(a.toString());
        System.out.println(b.toString());
        Date date = new Date();

        T[] array;
    }



    class A implements Cloneable{
        public String var1;
        public int var2;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            super.clone();
            System.out.println("clone()-----------");
            A newObject = new A();
            newObject.var1 = this.var1;
            newObject.var2 = this.var2;
            return newObject;
        }

        @Override
        public String toString() {
            return "var1=" + this.var1 + "; var2=" + this.var2;
        }

    }



}
