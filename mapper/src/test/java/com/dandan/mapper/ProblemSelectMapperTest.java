package com.dandan.mapper;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.dandan.common.utils.files.ExportFileUtils;
import com.dandan.common.utils.files.rowModel.SheetModel;
import com.dandan.mapper.resultset.ProblemOrderResult;
import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.Data;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by dandan On 十月 12 2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProblemSelectMapperTest {


    @Autowired
    private ProblemSelectMapper problemSelectMapper;


    @Test
    public void selectOrderServiceQuality() {
        String startTime = "2021-04-01";
        String endTime = "2021-05-01";

        List<ProblemOrderResult> results = problemSelectMapper.selectOrderByTime(startTime, endTime);

        Map<String,OrderServiceQualityResult> map = new HashMap<>();
        for (ProblemOrderResult result : results) {

            OrderServiceQualityResult data = map.get(result.getCityName());
            if(data == null){
                data = new OrderServiceQualityResult();
                map.put(result.getCityName(),data);
                data.setCityName(result.getCityName());
            }

            data.setOrderNum(data.getOrderNum() + 1);

            if(result.getComplaintsOrder().equals("Y")){
                data.setComplaintOrderNum(data.getComplaintOrderNum() + 1);
            }

            if(result.getSeriousProblem() != null){
                data.setSeriousOrderNum(data.getSeriousOrderNum() + 1);
            }

            String firstCategory1 = problemSelectMapper.selectCurrentProblemByOrderId(result.getOrderId());
            if(firstCategory1 == null || firstCategory1.equals("")){
                firstCategory1 = problemSelectMapper.selectHistoryProblemByOrderId(result.getOrderId());
            }

            if(firstCategory1 != null && !firstCategory1.equals("")){

                if(firstCategory1.contains("36")){
                    data.setArtisanServeProblemNum(data.getArtisanServeProblemNum() + 1);
                } else if(firstCategory1.contains("37")){
                    data.setArtisanTechProblemNum(data.getArtisanTechProblemNum() + 1);
                }
            }
        }

        List<List<String>> datas = new ArrayList<>();
        for (Map.Entry<String, OrderServiceQualityResult> entry : map.entrySet()) {
            OrderServiceQualityResult value = entry.getValue();
            List<String> list = new LinkedList<>();
            list.add(value.getCityName());
            list.add(value.getOrderNum()+"");
            list.add(value.getComplaintOrderNum()+"");
            list.add(value.getSeriousOrderNum()+"");
            list.add(value.getArtisanServeProblemNum()+"");
            list.add(value.getArtisanTechProblemNum()+"");
            datas.add(list);
        }


        String fileName = "/Users/dandan/Documents/export_files/城市维度-四月服务质量.xlsx";
        ExportFileUtils.writeExcel(datas,fileName, OrderServiceQualityResult.class);



    }

    @Data
    public class OrderServiceQualityResult extends BaseRowModel {
        @ExcelProperty(value = "城市")
        private String cityName;
        @ExcelProperty(value = "工单总数量")
        private int orderNum;
        @ExcelProperty(value = "投诉数量")
        private int complaintOrderNum;
        @ExcelProperty(value = "重大问题数量")
        private int seriousOrderNum;
        @ExcelProperty(value = "服务投诉数量")
        private int artisanServeProblemNum;
        @ExcelProperty(value = "技术投诉数量")
        private int artisanTechProblemNum;
    }

    @Test
    public void modifyArtisanBill() {



    }


}
