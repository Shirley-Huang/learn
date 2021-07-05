package com.dandan.other.keywords.TransientKey;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author dandan
 * @Date 2021/2/20
 */
@Data
public class User implements Serializable {

    /**
     * 若实现Externalizable接口，需重写writeExternal方法和readExternal方法
     * 实现自定义控制属性序列化
     */

    private String userName;
    //引用类型默认null
    private transient String password;

    //static类型不会被序列化
    private static String key = "value";

    //基本类型默认为该类型默认值
    private transient int age;
    private transient char sex;
    private transient boolean star;
    private transient long createTime;
    private transient double price;

    public User(String userName, String password, int age, char sex, boolean star, long createTime, double price) {
        this.userName = userName;
        this.password = password;
        this.age = age;
        this.sex = sex;
        this.star = star;
        this.createTime = createTime;
        this.price = price;
    }

}
