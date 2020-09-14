package com.dandan.model.test;

/**
 * Created by dandan On 八月 28 2019
 */
public class ClassLoaderTest {

    public static void main(String[] args) {

        Class clazz = ClassLoaderTest.class;
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getParent().getParent());

    }

    public void loadClass() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        //classLoader.loadClass("Test01");
        Class.forName("Test02");



    }


}
