package com.dandan.model.pojo.jiangyun;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class OrderResponsibilityEmployeeContrail implements Serializable {

    private int id;

    private String employeeId;
    private String employeeName;
    private String employeeRole;

    private String orderStatusCode;
    private String orderStatusName;

    private String changeEmployeeNote;
    private Date createTime;
    private String orderId;


}
