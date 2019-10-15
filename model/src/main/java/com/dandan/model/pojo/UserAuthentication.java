package com.dandan.model.pojo;

import lombok.*;

import java.io.Serializable;

/**
 * Created by dandan On 八月 27 2019
 */
@Data
public class UserAuthentication implements Serializable {

    private Integer id;
    private String name;
    private String idCard;
    private String nativePlace;
    private Integer userId;


}
