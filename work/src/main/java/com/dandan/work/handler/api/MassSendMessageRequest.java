package com.dandan.work.handler.api;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2020/12/30
 */
@Data
public class MassSendMessageRequest {
    private List<String> openIds;
    //图文消息id
    private String mediaId;
    //群发消息类型
    private String msgType;
    //文本内容
    private String content;
    //图文消息被判定转载时，是否继续群发 ，1继续，0停止，默认0
    private int sendIgnoreReprint;
}

