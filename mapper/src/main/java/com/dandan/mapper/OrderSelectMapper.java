package com.dandan.mapper;

import com.dandan.model.pojo.jiangyun.filter.ArtisanIncomeFilter;
import com.dandan.model.pojo.jiangyun.filter.TakeOrderTimeFilter;
import com.dandan.model.pojo.jiangyun.result.OrderArtisanIncome;
import com.dandan.model.pojo.jiangyun.result.TakeOrderTime;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
public interface OrderSelectMapper {


    /**
     * 接单均单时长统计
     * @param filter
     * @return
     * @throws Exception
     */
    List<TakeOrderTime> selectTakeOrderTimeOrdersByFilter(@Param("filter") TakeOrderTimeFilter filter) throws Exception;

    List<String> selectOrderIdsByFilter(@Param("filter") TakeOrderTimeFilter filter) throws Exception;

    TakeOrderTime selectOrderByOrderId(@Param("orderId") String orderId) throws Exception;

    /**
     * 查询师傅收入详情
     * @param filter
     * @return
     */
    List<OrderArtisanIncome> selectOrderArtisanIncomeByFilter(@Param("filter") ArtisanIncomeFilter filter);



}
