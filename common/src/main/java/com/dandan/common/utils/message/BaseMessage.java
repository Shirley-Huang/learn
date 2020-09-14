package com.dandan.common.utils.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseMessage {

    private String toUserName;
    private String fromUserName;
    private Long createTime;
    private String msgType;

}
