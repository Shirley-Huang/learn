package com.dandan.other.inherit;

/**
 * @Description
 * @Author dandan
 * @Date 2020/6/29
 */
public class SubClass extends SuperClass implements Fly,Swim{

    private void test(){
        Skill one = (Skill) new SubClass();



    }



}


interface Fly {

}

interface Swim {

}

interface Skill{

}