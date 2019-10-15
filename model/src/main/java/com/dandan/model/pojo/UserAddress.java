package com.dandan.model.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * Created by dandan On 八月 27 2019
 */
@Data
public class UserAddress implements Serializable {

    private Integer id;
    private String provinceCode;
    private String provinceName;
    private String cityCode;
    private String cityName;
    private String districtCode;
    private String districtName;
    private String detailAddress;
    private Integer userId;

}
