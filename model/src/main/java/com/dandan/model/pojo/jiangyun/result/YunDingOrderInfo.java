package com.dandan.model.pojo.jiangyun.result;

import com.dandan.model.pojo.jiangyun.OrderSerialNumber;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2020/11/12
 */
@Data
public class YunDingOrderInfo {

    private String orderId;
    private String partnerOrderNumber;
    private String statusId;
    private String currentOrder;
    private String employeeNote;

    private List<OrderSerialNumber> serialNumbers;


}
