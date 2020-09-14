package com.dandan.model.pojo.jiangyun;

import com.dandan.common.model.pojo.Bool;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class OrderProperty implements Serializable {

    private Integer id;
    private Bool customerConfirmArtisanServeTime;
    private Bool customerConfirmServerTimeYes;
    private String orderId;
    private Date  createTime;
    private Date  updateTime;
    //微信推送评价消息次数
    private Integer   wxPushCount;
    //爽约超时次数
    private Integer  missDateTimeoutCount;
    //未预约超时次数
    private Integer  appointmentTimeoutCount;

    /**
     * 非客服处理时长-单位：秒（接单均单时长统计使用）
     */
    private Integer notEmployeeProcessDurationSecond;

    /**
     * 修改符合上门条件标记的时间（即修改商品是否收到货和客户是否需10天内上门这两个标记）
     */
    private Date modifyVisitConditionMarkTime;

    /**
     * 第一次待抢单状态的时间 （派单均单时长统计使用）
     */
    private Date firstGrabTime;


    /**
     * 是否将指定的属性置空
     */
    private Boolean specialPropertySetNull;

    /**
     * 改约验证码
     */
    private String repairTimeVerifyCode;

}
