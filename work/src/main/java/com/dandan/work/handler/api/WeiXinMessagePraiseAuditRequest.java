package com.dandan.work.handler.api;

import lombok.Data;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-10
 */
@Data
public class WeiXinMessagePraiseAuditRequest {

    private String openId;
    private String orderId;
    private String price;

}
