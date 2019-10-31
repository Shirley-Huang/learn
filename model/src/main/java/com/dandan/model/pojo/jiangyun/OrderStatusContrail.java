package com.dandan.model.pojo.jiangyun;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class OrderStatusContrail implements Serializable {

    private Integer id;
    private Date createTime;
    private String statusName;
    private String statusCode;

    private String orderId;



}
