package com.dandan.common.utils.files.rowModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class TakeOrderTimeModel extends BaseRowModel {

    @ExcelProperty(value = "工单号",index = 0)
    private  String orderId;

    @ExcelProperty(value = "商户名称",index = 1)
    private String merchantName;

    @ExcelProperty(value = "待联系客户状态第一次分配客服时间",index = 2)
    private String firstAssignContactCustomerTime;

    @ExcelProperty(value = "客服姓名",index = 3)
    private String employeeName;

    @ExcelProperty(value = "第一次抢单时间",index = 4)
    private String firstContactCustomerTime;

    @ExcelProperty(value = "待联系客户状态后面的第一个待抢单时间",index = 5)
    private String firstGrabingCreateTime;

    @ExcelProperty(value = "总时长",index = 6)
    private int allEmployeeProcessdurationSecond;

    @ExcelProperty(value = "非客服处理时长",index = 7)
    private int notEmployeeProcessDurationSecond;

    @ExcelProperty(value = "客服处理时长",index = 8)
    private int emplyeeProcessDurationSecond;





}
