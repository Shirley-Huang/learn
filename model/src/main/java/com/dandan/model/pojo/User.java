package com.dandan.model.pojo;

import com.dandan.model.enums.SexType;
import lombok.*;

import java.io.Serializable;
import java.util.List;

/**
 * Created by dandan On 八月 24 2019
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -4467237132305044109L;

    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String mobile;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private SexType sex;

    private UserAuthentication authentication;

    /**
     * 用户地址
     */
    private List<UserAddress> addresses;


}
