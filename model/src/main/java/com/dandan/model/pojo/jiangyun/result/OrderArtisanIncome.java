package com.dandan.model.pojo.jiangyun.result;

import com.dandan.model.pojo.jiangyun.Order;
import com.dandan.model.pojo.jiangyun.OrderArtisanRewardPunishment;
import com.dandan.model.pojo.jiangyun.OrderExtraChargeItemApply;
import com.dandan.model.pojo.jiangyun.OrderProduct;
import com.jiangyun.framework.model.Bool;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class OrderArtisanIncome {


    private String orderId;
    private Order order;
    private List<OrderProduct> orderProducts;
    private List<OrderArtisanRewardPunishment> rewardPunishments;
    private List<OrderExtraChargeItemApply> extraChargeApply;




}
