package com.dandan.other.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by dandan On 八月 30 2019
 */
@Data
public class C extends B implements A {

    @Autowired
    private String privateCvar1;
    String defaultCvar1;
    protected String protectedCvar1;
    public String publicCvar1;

    public A getAMethod() {
        return null;
    }

    private void privateCMethod(){

    }

    void defaultCMethod(){

    }

    protected void protectedCMethod(){

    }

    public void publicCMethod(){

    }

    static {
        System.out.println("C static method");
    }

    {
        System.out.println("C code---");
    }

    public C() {
        System.out.println("C constructor ---");
    }

}
