package com.dandan.other.spring.aop.aspect.joinPoint;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-16
 *
 * org.aspectj.lang.reflect.SourceLocation.JoinPoint
 */
public interface MyJoinPoint {

    /**
     * 切点：  execution(* com.dandan.other.spring.aop.service.MyService.createOrder(..))
     */

    /**
     * 连接点所在位置的相关信息
     * @return  execution(String com.dandan.other.spring.aop.service.MyService.createOrder(String,String))
     */
    @Override
    String toString();

    /**
     * 连接点所在位置的简短相关信息
     * @return  execution(MyService.createOrder(..))
     */
    String toShortString();

    /**
     * 连接点所在位置的全部相关信息
     * @return  execution(public abstract java.lang.String com.dandan.other.spring.aop.service.MyService.createOrder(java.lang.String,java.lang.String))
     */
    String toLongString();

    /**
     * AOP代理对象。也就是com.sum.proxy.$Proxy18
     * @return  com.dandan.other.spring.aop.service.MyServiceImpl@3967e60c
     */
    Object getThis();

    /**
     * 目标对象，一般我们都需要他或者（也就是定义方法的接口或类，为什么会是接口呢？这主要是在目标对象本身是动态代理的情况下，例如Mapper所以返回的是定义方法的对象）
     * @return  com.dandan.other.spring.aop.service.MyServiceImpl@3967e60c
     */
    Object getTarget();


    /**
     * 方法请求参数列表
     * @return
     * 第1个参数：100100
     * 第2个参数：黄丹丹
     */
    Object[] getArgs();

    /**
     * 当前连接点签名
     * @return
     */
    Signature getSignature();

    /**
     * 连接点类型
     * @return  method-execution0
     */
    String getKind();

    /**
     * 返回连接点静态部分
     * @return
     */
    JoinPoint.StaticPart getStaticPart();


}
