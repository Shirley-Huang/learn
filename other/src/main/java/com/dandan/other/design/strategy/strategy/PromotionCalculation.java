package com.dandan.other.design.strategy.strategy;

import com.dandan.other.design.strategy.strategy.pojo.Order;

import java.math.BigDecimal;

/**
 * @Description 策略模式
 * @Author dandan
 * @Date 2019-12-14
 */
public interface PromotionCalculation {

    /**
     * 计算订单的促销价格
     * @param order
     * @return
     */
    Order calculation(Order order);

}
