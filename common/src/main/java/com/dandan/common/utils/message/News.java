package com.dandan.common.utils.message;

import lombok.Data;

@Data
public class News {

    private String Title;//图文标题
    private String Description;//图文描述
    private String PicUrl;//图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
    private String Url;//点击图文消息跳转链接

}
