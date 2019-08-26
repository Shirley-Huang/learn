package com.dandan.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by dandan On 八月 24 2019
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String password;
    private String mobile;
    private Integer age;
    private String sex;

}
