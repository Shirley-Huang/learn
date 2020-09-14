package com.dandan.model.pojo.jiangyun.result;

import com.dandan.model.pojo.jiangyun.OrderProperty;
import com.dandan.model.pojo.jiangyun.OrderResponsibilityEmployeeContrail;
import com.dandan.model.pojo.jiangyun.OrderStatusContrail;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-25
 */
@Data
public class TakeOrderTime {


    private String orderId;
    private String merchantName;
    private List<OrderStatusContrail> statusContrails;
    private List<OrderResponsibilityEmployeeContrail> employeeContrails;
    private OrderProperty orderProperty;

}
