package com.dandan.model.pojo.jiangyun;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-25
 */
@Data
public class OrderArtisanRewardPunishment implements Serializable {

    private Integer id;
    private String code;
    private String name;
    private BigDecimal amount;
    private Date createTime;

}
