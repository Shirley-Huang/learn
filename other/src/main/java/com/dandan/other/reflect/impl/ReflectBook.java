package com.dandan.other.reflect.impl;

import com.dandan.other.model.B;
import com.dandan.other.model.C;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by dandan On 九月 02 2019
 */
public class ReflectBook {

    private final static String TAG = "reflect book class";

    //创建对象
    @Test
    public void reflectNewInstance(){
        try {
            Class<?> bookClass = Class.forName("com.dandan.other.reflect.impl.Book");
            Book book = (Book) bookClass.newInstance();
            book.setName("Java从入门到放弃");
            book.setAuthor("黄丹丹");
            System.out.println(book.toString());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }

    //反射私有到方法
    @Test
    public void reflectPrivateMethod(){
        Class<Book> bookClass = Book.class;
        try {
            Method declaredMethod = bookClass.getDeclaredMethod("declaredMethod",int.class);
            declaredMethod.setAccessible(true);
            Object book = bookClass.newInstance();
            String string = (String)declaredMethod.invoke(book,0);
            System.out.println(string);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    //反射私有属性
    @Test
    public void reflectPrivateFiled(){
        Book book = new Book();
        Class<? extends Book> bookClass = book.getClass();
        try {
            Field filedTag = bookClass.getDeclaredField("TAG");
            filedTag.setAccessible(true);
            String tag = (String)filedTag.get(book);
            System.out.println(tag);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    //反射私有构造函数
    @Test
    public void reflectPrivateConstructor(){
        Class<Book> bookClass = Book.class;
        try {

            Constructor constructor = bookClass.getDeclaredConstructor(String.class,String.class);
            constructor.setAccessible(true);
            Book book = (Book)constructor.newInstance("Java虚拟机","Shirley");
            System.out.println(book.toString());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
