package com.dandan.model.pojo;

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

}
