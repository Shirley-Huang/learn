package com.dandan.other.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-16
 */
public class MyServiceAspect {

    public void beforeHandler(){
        System.out.println("前置通知");
    }

    public void afterHandler(){
        System.out.println("后置通知");
    }

    public void returnHandler(Object name){
        System.out.println("返回通知:"+name);
    }

    public void throwExceptionHandler(Throwable ex){
        System.out.println("异常通知" + ex.getMessage());
    }

    public Object doAround(ProceedingJoinPoint jp)  {


        try {
            System.out.println("环绕通知开始");

//            System.out.println("toString() ---" + jp.toString());//连接点所在位置的相关信息
//            System.out.println("toShortString() ---" + jp.toShortString());//连接点所在位置的简短相关信息
//            System.out.println("toLongString() ---" + jp.toLongString());//连接点所在位置的全部相关信息
//            System.out.println(jp.getThis());
//            System.out.println(jp.getTarget());
//
//            Object[] args = jp.getArgs();
//            for (int i = 1; i <= args.length; i++) {
//                System.out.println("第"+i+"个参数：" + args[i - 1]);
//            }


            Signature signature = jp.getSignature();
            System.out.println(signature.getName());
            System.out.println(signature.getDeclaringType());
            System.out.println(signature.getDeclaringTypeName());
            System.out.println(signature.getModifiers());
            System.out.println(signature.toString());
            System.out.println(signature.toShortString());
            System.out.println(signature.toLongString());

            System.out.println();

            System.out.printf(jp.getKind());

            JoinPoint.StaticPart staticPart = jp.getStaticPart();
            System.out.println(staticPart.getId());
            System.out.println(staticPart.getKind());
            System.out.println(staticPart.getSignature().getName());
            System.out.println(staticPart.getSourceLocation());
            System.out.println(staticPart.toString());

            System.out.println();
            System.out.println("MethodSignature------");
            MethodSignature methodSignature = (MethodSignature)jp.getSignature();
            System.out.println(methodSignature.getMethod());
            System.out.println(methodSignature.getReturnType());
            String[] parameterNames = methodSignature.getParameterNames();
            for (String parameterName : parameterNames) {
                System.out.println("parameterName");
                System.out.println(parameterName);
            }



//            Object result = pjp.proceed();
            System.out.println("环绕通知结束");
//            return result;
        } catch (Throwable throwable) {

        }
        return null;
    }

}
