package com.dandan.mapper;

import com.dandan.model.pojo.Order;

import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
public interface OrderMapper {

    List<Order> selectOrderLimit();

}
