package com.dandan.other.spring.aop.service;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-16
 */
public class MyServiceImpl implements MyService {

    @Override
    public String createOrder(String orderId, String createByName){
//        try{
//            throw new RuntimeException("message is not null");
//        }catch (Exception e){
//            throw e;
//        }
        return  createByName + "创建工单:" + orderId;
    }

}
