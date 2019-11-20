package com.dandan.work.handler.api.bo;

import lombok.Data;

/**
 * @Description
 * @Author dandan
 * @Date 2019-11-20
 */
@Data
public class CancelOrderBO {

    private String orderId;
    //工单取消要求方
    private String orderCancelDemander;
    private String cancelReasonTypeCode;
    private String cancelReasonDescription;

    /**
     * 忽略验证
     */
    private Boolean ignoreVerify;

    /**
     * 短信验证码
     */
    private String verifyCode;

}
