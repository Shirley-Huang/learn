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
public class OrderArtisanIncomeAmountModel extends BaseRowModel {

    @ExcelProperty(value = "工单号",index = 0)
    private String t0;
    @ExcelProperty(value = "师傅类型",index = 1)
    private String t1;
    @ExcelProperty(value = "工单类型",index = 2)
    private String t2;
    @ExcelProperty(value = "是否空跑",index = 3)
    private String t3;
    @ExcelProperty(value = "工单锁量",index = 4)
    private String t4;
    @ExcelProperty(value = "商户收入",index = 5)
    private String t5;
    @ExcelProperty(value = "师傅总收入",index = 6)
    private String t6;
    @ExcelProperty(value = "附加费",index = 7)
    private String t7;
    @ExcelProperty(value = "师傅申请",index = 8)
    private String t8;
    @ExcelProperty(value = "安装工具磨损费",index = 9)
    private String t9;
    @ExcelProperty(value = "服务费",index = 10)
    private String t10;
    @ExcelProperty(value = "好评有奖",index = 11)
    private String t11;
    @ExcelProperty(value = "推荐延保",index = 12)
    private String t12;
    @ExcelProperty(value = "评分奖",index = 13)
    private String t13;
    @ExcelProperty(value = "ojj备库补助",index = 14)
    private String t14;
    @ExcelProperty(value = "未及时预约",index = 15)
    private String t15;
    @ExcelProperty(value = "未沟通设置上门时间",index = 16)
    private String t16;
    @ExcelProperty(value = "准时上门",index = 17)
    private String t17;
    @ExcelProperty(value = "迟到或早到",index = 18)
    private String t18;
    @ExcelProperty(value = "爽约",index = 19)
    private String t19;
    @ExcelProperty(value = "未穿戴工服",index = 20)
    private String t20;
    @ExcelProperty(value = "非本人签到",index = 21)
    private String t21;
    @ExcelProperty(value = "未帮助配置并指导使用",index = 22)
    private String t22;
    @ExcelProperty(value = "重大问题",index = 23)
    private String t23;
    @ExcelProperty(value = "商户名称")
    private String merchantName;
    @ExcelProperty(value = "商品信息")
    private String productName;
    @ExcelProperty(value = "省名")
    private String provinceName;

}
