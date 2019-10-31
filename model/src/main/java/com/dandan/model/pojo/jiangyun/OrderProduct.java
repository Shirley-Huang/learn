package com.dandan.model.pojo.jiangyun;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class OrderProduct implements Serializable {

    private Integer id;
    private String name;
    private Integer number;
    private String secondCategoryName;
    private String productId;
    private String categoryServingId;
    private String categoryServingName;




}
