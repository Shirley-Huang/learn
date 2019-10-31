package com.dandan.other.spring.aop.aspect.joinPoint;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-17
 */
public interface MySignature {

    /**
     *
     * @return  String com.dandan.other.spring.aop.service.MyService.createOrder(String,String)
     */
    @Override
    String toString();

    /**
     *
     * @return  MyService.createOrder(..)
     */
    String toShortString();

    /**
     *
     * @return public abstract java.lang.String com.dandan.other.spring.aop.service.MyService.createOrder(java.lang.String,java.lang.String)
     */
    String toLongString();

    /**
     * 返回方法的名称
     * @return  createOrder
     */
    String getName();

    /**
     * 修饰符
     * @return
     */
    int getModifiers();

    /**
     *方法所在对象
     * @return  interface com.dandan.other.spring.aop.service.MyService
     */
    Class getDeclaringType();

    /**
     *方法所在对象名称
     * @return  com.dandan.other.spring.aop.service.MyService
     */
    String getDeclaringTypeName();


}
