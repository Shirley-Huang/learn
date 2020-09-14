package com.dandan.model.pojo.jiangyun;

import com.dandan.common.model.pojo.Bool;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by dandan On 十月 12 2019
 */
@Data
public class Order {

    private String orderId;
    private String partnerOrderNum;
    private String merchantId;
    private String merchantName;
    private Integer statusId;
    private String artisanName;
    private String artisanMobile;


    private String artisanLeaderTypeCode;
    private Bool teamOrder;
    private String employeeNote;
    private BigDecimal merchantTotalPaymentAmount;
    private BigDecimal artisanIncomeAmount;
    private BigDecimal artisanAdditionAmount;
    private BigDecimal artisanServiceAmount;
    private BigDecimal artisanDistancePaymentAmount;
    private BigDecimal artisanPraiseAwardAmount;
    private BigDecimal artisanRecommendAwardAmount;





}
