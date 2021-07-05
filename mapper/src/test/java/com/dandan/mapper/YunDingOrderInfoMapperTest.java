package com.dandan.mapper;

import com.dandan.common.utils.files.ExportFileUtils;
import com.dandan.common.utils.files.ImportFileUtils;
import com.dandan.model.pojo.jiangyun.OrderSerialNumber;
import com.dandan.model.pojo.jiangyun.result.YunDingOrderInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2020/11/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class YunDingOrderInfoMapperTest {

    @Autowired
    private OrderSelectMapper orderSelectMapper;

    /**
     * 处理云丁无SN信息的工单
     */
    @Test
    public void test01() throws Exception{
        String filePath = "/Users/dandan/Documents/export_files/云丁工单信息同步.xls";
        List<List<String>> result = ImportFileUtils.readExcel(filePath);
        for (int i = 1; i < result.size(); i++) {
            List<String> row = result.get(i);

            //String partnerOrderNumber = "WO2020011500000434";
            String partnerOrderNumber = row.get(0);
            YunDingOrderInfo yunDingOrderInfo = orderSelectMapper.selectYunDingOrderInfoByPartnerOrderNumber(partnerOrderNumber);
            if(yunDingOrderInfo.getSerialNumbers() != null){
                for (OrderSerialNumber serialNumber : yunDingOrderInfo.getSerialNumbers()) {
                    if(serialNumber.getSerialNumberType().equals("OLD_FACEPLATE")){
                        row.add(3,serialNumber.getSerialNumber());
                    }else if(serialNumber.getSerialNumberType().equals("OLD_LOCK_BODY")){
                        row.add(4,serialNumber.getSerialNumber());
                    }
                }
            }

        }
        ExportFileUtils.writeExcel(result,filePath);
    }


    /**
     * 处理云丁状态的工单
     */
    @Test
    public void test02() throws Exception{
        String filePath = "/Users/dandan/Documents/export_files/云丁工单信息同步2.xlsx";
        List<List<String>> result = ImportFileUtils.readExcel(filePath);
        for (int i = 1; i < result.size(); i++) {
            List<String> row = new ArrayList<>();
            row = result.get(i);

            //String partnerOrderNumber = "WO2020011500000434";
            String partnerOrderNumber = row.get(0);
            YunDingOrderInfo yunDingOrderInfo = orderSelectMapper.selectYunDingOrderInfoByPartnerOrderNumber(partnerOrderNumber);
            String statusId = yunDingOrderInfo.getStatusId();
            String currentOrder = yunDingOrderInfo.getCurrentOrder();
            String statusName = "";
            if(currentOrder.equals("Y")){
                //当前工单
                if(statusId.equals("2")){//待抢单
                    statusName = "待安排师傅";
                }else if(statusId.equals("8")){
                    statusName = "待师傅联系";
                }else if(statusId.equals("9")){
                    statusName = "待师傅上门";
                }else if(statusId.equals("11") || statusId.equals("10") || statusId.equals("12") || statusId.equals("13")){
                    statusName = "待施工";
                }else if(statusId.equals("14")){//待沟通
                    statusName = "完成";
                }
            }else{
                //历史工单
                if(statusId.equals("1")){
                    statusName = "完成";
                    if(yunDingOrderInfo.getEmployeeNote().contains("【系统】提前结束工单")){
                        statusName = "上门未安装";
                    }
                }else if(statusId.equals("2")){
                    statusName = "取消";
                }
            }
            row.add(4,statusName);
            row.add(5,yunDingOrderInfo.getOrderId());

        }
        ExportFileUtils.writeExcel(result,filePath);
    }


}
