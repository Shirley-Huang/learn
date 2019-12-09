package com.dandan.work.handler.api.problem;

import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-06
 */
@Data
public class Problem {

    private Integer id;//问题编号
    private Integer signCount;//标记次数
    private Boolean tomorrowDeal;//是否隔天处理
    private Boolean complaintsOrder;//是否为投诉工单
    private Boolean complaintRisk ;//是否为投诉风险工单
    private String complaintChannel ;//投诉渠道
    private Boolean customerReminder;//是否为催单
    private String orderId;//工单id
    private String createTime;//问题创建时间
    private String waitEmployeeDealTime;                // 等待客服处理时间
    private String waitMerchantDealTime;                // 等待商户处理时间

    private Integer problemStatusId;//当前状态id
    private String statusDescription;//当前状态描述
    private Integer problemCategoryId;//当前问题分类id
    private Integer problemFirstCategoryId;// 问题一级类别id
    private String problemFirstCategoryName;// 问题一级类别名称
    private Integer problemSecondCategoryId;// 问题二级类别id
    private String problemSecondCategoryName;// 问题二级类别名称

    private String createdById;//问题创建者id
    private String createdByName;//问题创建者姓名
    private String createdByAccountType;//问题创建者类型
    private Integer processorRoleId;//问题处理者组id
    private String processorId;//问题处理者id
    private String processorName;//问题处理者姓名
    private String responsibilityEmployeeId;//追责客服id
    private String responsibilityEmployeeName;//追责客服姓名
    private String merchantId;//商户id
    private String merchantName;//商户姓名
    private String customerName;//客户姓名
    private String customerMobile;//客户手机号
    private String artisanName;//师傅姓名
    private String artisanMobile;//师傅手机号

    private String leaderName;//队长姓名
    private String leaderMobile;//队长手机号

    private String note;//问题描述
    private List<String> notePictures;//问题图片
    private String videoUrl;//视频url

    private Boolean orderProblem;//是否为工单问题
    private Integer orderCurrentProblemNum;//工单当前问题数量

    private String processorResultCode;//处理结果
    private Boolean returnOrderSituationVraie;//师傅情况是否属实

    private String customerProvinceName;
    private String customerCityName;

}
