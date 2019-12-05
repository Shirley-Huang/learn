package com.dandan.other.base;

/**
 * @Description
 * @Author dandan
 * @Date 2019-11-21
 */
public class StaticAndNonStatic extends AbstractAnimal implements Fly{

    @Override
    public void fly01() {

    }

    @Override
    public void fly03() {

    }

    @Override
    void sum() {

    }

}

interface Fly{

    int i = 10;

    void fly01();

    void fly03();
}

abstract class AbstractAnimal{
    int a = 100;

    abstract void  sum() ;

    void add(){
        System.out.println("add");
    }
}

