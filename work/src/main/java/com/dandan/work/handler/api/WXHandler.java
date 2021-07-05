package com.dandan.work.handler.api;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-10
 */
public interface WXHandler {

    /**
     * 发送好评有奖微信模版消息
     */
    public void pushWeixinPraiseAuditMessage(WeiXinMessagePraiseAuditRequest req) throws Exception ;

    void sendMassMessage(MassSendMessageRequest request) throws Exception;

}
