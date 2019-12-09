package com.dandan.work.handler.api.bo;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-06
 */
@Data
public class ModifyProblemBO {
    private Integer id;//问题编号
    private String processorResultCode;//处理结果（师傅服务问题，师傅退单）
    private Boolean returnOrderSituationVraie;//师傅情况是否属实
    private String problemArtisanId;//问题师傅id
    private String problemArtisanName;//问题师傅名字
    private String cancelReasonTypeCode;
    private String cancelReasonDescription;

    private Integer problemStatusId;               // 问题工单当前状态
    private Integer problemCategoryId;      //问题分类id
    private Integer problemFirstCategoryId; //一级问题分类id
    private String problemFirstCategoryName;//一级问题分类名称
    private Integer problemSecondCategoryId;// 二级问题分类id
    private String problemSecondCategoryName;//二级问题分类名称

    private Boolean tomorrowDeal;           // 是否隔天处理
    private Boolean complaintsOrder;        // 是否为投诉工单
    private Boolean complaintRisk;  //是否为投诉风险单
    private String complaintChannel; //投诉渠道
    private Boolean customerReminder;       // 是否催单

    private Integer signCount;              // 标记次数
    private Integer processorRoleId;        // 处理组id
    private String processorId;            //处理人id
    private String processorName;           //处理人姓名
    private String responsibilityEmployeeId;//追责客服id
    private String responsibilityEmployeeName;//追责客服姓名
    private String note;                    // 备注
    private List<String> notePictures;       // 问题描述图片

}
