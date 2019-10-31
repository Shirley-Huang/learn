package com.dandan.common.utils.files.rowModel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

/**
 * Created by dandan On 十月 12 2019
 */
@Data
public class SheetModel extends BaseRowModel {

    @ExcelProperty(value = "工单号",index = 0)
    private String orderId;

    @ExcelProperty(value = "第三方单号",index = 1)
    private String partnerOrderNum;

    @ExcelProperty(value = "商户id",index = 2)
    private String merchantId;

    @ExcelProperty(value = "商户名称",index = 3)
    private String merchantName;

    @ExcelProperty(value = "状态id",index = 4)
    private Integer statusId;

    @ExcelProperty(value = "师傅姓名",index = 5)
    private String artisanName;

    @ExcelProperty(value = "师傅手机号",index = 6)
    private String artisanMobile;

}
