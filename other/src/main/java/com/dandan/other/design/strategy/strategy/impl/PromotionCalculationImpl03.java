package com.dandan.other.design.strategy.strategy.impl;

import com.dandan.other.design.strategy.strategy.PromotionCalculation;
import com.dandan.other.design.strategy.strategy.pojo.Order;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-14
 */
public class PromotionCalculationImpl03 implements PromotionCalculation {

    @Override
    public Order calculation(Order order) {
        System.out.println("promotion03对订单进行了计算");

        return order;
    }

}
