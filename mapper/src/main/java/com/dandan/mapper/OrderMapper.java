package com.dandan.mapper;

import com.dandan.model.pojo.jiangyun.Order;
import com.dandan.model.pojo.jiangyun.OrderProperty;
import com.dandan.model.pojo.jiangyun.OrderResponsibilityEmployeeContrail;
import com.dandan.model.pojo.jiangyun.OrderStatusContrail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
@Mapper
public interface OrderMapper {

    List<Order> selectOrderLimit();

    List<OrderStatusContrail> selectOrderStatusContrailsByOrderId(@Param("orderId") String orderId) throws Exception;

    List<OrderResponsibilityEmployeeContrail> selectOrderResponsibilityEmployeeContrailByOrderId(@Param("orderId") String orderId) throws Exception;

    List<OrderProperty> selectOrderPropertyByOrderId(@Param("orderId") String orderId) throws Exception;






}
