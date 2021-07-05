package com.dandan.mapper.resultset;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author dandan
 * @Date 2021/5/10
 */
@Data
public class ProblemOrderResult implements Serializable {

    private String orderId;
    private String cityName;
    private String complaintsOrder;
    private String seriousProblem;

}
