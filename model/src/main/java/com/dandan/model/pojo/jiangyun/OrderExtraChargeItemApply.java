package com.dandan.model.pojo.jiangyun;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-25
 */
@Data
public class OrderExtraChargeItemApply implements Serializable {

    private Integer id;
    private BigDecimal applyTotalPrice;
    private Integer applyStatusId;

}
