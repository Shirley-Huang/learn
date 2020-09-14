package com.dandan.other.design.strategy.strategy.test;

import com.dandan.other.design.strategy.strategy.PromotionCalculation;
import com.dandan.other.design.strategy.strategy.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.Set;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-14
 */
public class PromotionCalculationService {

    @Autowired
    private Map<String, PromotionCalculation> promotionCalculations;

    @Autowired
    private ApplicationContext context;

    @Test
    public Order prepareOrder(Order order, String promotion){

        ((PromotionCalculation)this.context.getBean(promotion)).calculation(order);

        return promotionCalculations.get(promotion).calculation(order);
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/spring/service-aop.xml");

        PromotionCalculationService service = (PromotionCalculationService)context.getBean("promotionCalculationService");
        Map<String, PromotionCalculation> promotionCalculations = service.getPromotionCalculations();
        Set<Map.Entry<String, PromotionCalculation>> entries = promotionCalculations.entrySet();
        for (Map.Entry<String, PromotionCalculation> entry : entries) {
            System.out.println(entry.getKey() + "--" + entry.getValue());
        }


    }

    public Map<String, PromotionCalculation> getPromotionCalculations() {
        return promotionCalculations;
    }

    public void setPromotionCalculations(Map<String, PromotionCalculation> promotionCalculations) {
        this.promotionCalculations = promotionCalculations;
    }

    public ApplicationContext getContext() {
        return context;
    }

    public void setContext(ApplicationContext context) {
        this.context = context;
    }

}
