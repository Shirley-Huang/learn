package com.dandan.other.model;

/**
 * Created by dandan On 八月 30 2019
 */
public abstract class B {

    private String privateBvar1;
    String defaultBvar1;
    protected String protectedBvar1;
    public String publicBvar1;

    private void privateBMethod(){

    }

    void defaultBMethod(){

    }

    protected void protectedBMethod(){

    }

    public void publicBMethod(){

    }

    public B() {
    }

    public B(String privateBvar1, String defaultBvar1, String protectedBvar1, String publicBvar1) {
        this.privateBvar1 = privateBvar1;
        this.defaultBvar1 = defaultBvar1;
        this.protectedBvar1 = protectedBvar1;
        this.publicBvar1 = publicBvar1;
    }

}
