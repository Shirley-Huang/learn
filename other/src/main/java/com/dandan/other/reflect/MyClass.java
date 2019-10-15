package com.dandan.other.reflect;

import com.dandan.other.model.B;
import com.dandan.other.model.C;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.TypeVariable;

/**
 * Created by dandan On 八月 29 2019
 */
public class MyClass extends B {

    public static void main(String[] args) {
        Class clazz = MyClass.class;

        MyClass obj = new MyClass();

        GenericType typeClass = new GenericType();
        for (TypeVariable typeParameter : typeClass.getTypeParameters()) {
            System.out.println(typeParameter);
        }

        System.out.println(obj.getClass().getClassLoader());
        System.out.println(clazz.getClassLoader());

        for (Constructor constructor : clazz.getConstructors()) {
            System.out.println(constructor);
        }

        for (Constructor declaredConstructor : clazz.getDeclaredConstructors()) {
            System.out.println(declaredConstructor);
        }

        System.out.println(clazz.getModifiers());

        //判断指定的Class对象是否表示一个java的基leixing
        System.out.println(clazz.isPrimitive());
        System.out.println(int.class.isPrimitive());


    }



    public String var1;
    public String var2;

    public MyClass() {
    }



    @Test
    public void generateClassObject(){
        System.out.println("=======生成Class对象的三种方式==========");
        System.out.println("Class.forName()--------");
        try {
            Class.forName("com.dandan.other.model.C");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("C.class---------");
        Class<C> cClazz = C.class;

        System.out.println("c.getClass()-----------");
        C c = new C();
        Class<? extends C> cClass = c.getClass();
    }

}
