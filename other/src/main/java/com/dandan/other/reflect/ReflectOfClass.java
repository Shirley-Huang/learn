package com.dandan.other.reflect;

import com.dandan.other.model.C;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by dandan On 八月 30 2019
 */
public class ReflectOfClass {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {


        Class<C> clazz = C.class;

        System.out.println("-------getConstructors---------");

        for (Constructor<?> constructor : clazz.getConstructors()) {
            System.out.println(constructor.getName());
        }

        System.out.println("-----getDeclaredFields----");

        for (Field declaredField : clazz.getDeclaredFields()) {
            System.out.println(declaredField.getName());
        }

        System.out.println("---------getFields----");
        for (Field field : clazz.getFields()) {
            System.out.println(field.getName());
        }

        System.out.println("----------getMethods--------");
        for (Method method : clazz.getMethods()) {
            System.out.println(method.getName());
        }

        System.out.println("----------getDeclaredMethods--------");
        for (Method method : clazz.getDeclaredMethods()) {
            System.out.println(method.getName());
        }

        Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");

        System.out.println("----------getClasses--------");
        for (Class<?> clazzClass : clazz.getClasses()) {
            System.out.println(clazzClass.getName());
        }

        System.out.println("----------getDeclaredClasses--------");
        for (Class<?> clazzClass : clazz.getDeclaredClasses()) {
            System.out.println(clazzClass.getName());
        }

        //获取类的包
        System.out.println(clazz.getPackage());
        //获取类的名字
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getName());
        //获取当前类继承的父类的名字
        System.out.println(clazz.getSuperclass());
        //获取当前类实现的接口
        for (Class<?> anInterface : clazz.getInterfaces()) {
            System.out.println(anInterface.getName());
        }

        System.out.println("--------指定属性或方法----------");

        Field publicCvar1 = clazz.getField("publicCvar1");
        System.out.println(publicCvar1.getName());
        Field protectedCvar1 = clazz.getDeclaredField("protectedCvar1");
        System.out.println(protectedCvar1.getName());
//        Field protectedCvar2 = clazz.getField("protectedCvar1");
//        System.out.println(protectedCvar2.getName());

        System.out.println("--------annotation-----啥是注解对象-");
        for (Annotation annotation : clazz.getAnnotations()) {
            System.out.println(annotation.toString());
        }
        for (Annotation annotation : clazz.getDeclaredAnnotations()) {
            System.out.println(annotation.toString());
        }


    }

}
