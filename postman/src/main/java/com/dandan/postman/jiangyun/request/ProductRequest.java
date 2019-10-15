package com.dandan.postman.jiangyun.request;

import lombok.Data;

import java.util.List;

@Data
public class ProductRequest {

    private String name;
    private Integer number;
    private String mainPicUrl;
    private Integer secondCategoryId;
    private String secondCategoryName;
    private String productId;




}
