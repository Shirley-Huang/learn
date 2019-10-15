package com.dandan.common.utils.files;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Font;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.metadata.TableStyle;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
public class ExportFileUtils {

    public static void writeExcel(List<List<String>> data) {

        OutputStream out = null;
        try{

            out = new FileOutputStream("/Users/dandan/Documents/import_files/工单列表.xlsx");

            ExcelWriter writer = EasyExcelFactory.getWriter(out);
            Sheet sheet = new Sheet(1,0, SheetModel.class);
            sheet.setSheetName("信息列表");
            sheet.setAutoWidth(true);
            TableStyle tableStyle = new TableStyle();
            Font headFont = new Font();
            headFont.setBold(true);
//            headFont.setFontHeightInPoints();
            tableStyle.setTableHeadFont(headFont);
//            sheet.setTableStyle(tableStyle);

            writer.write0(data,sheet);
            writer.finish();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


}
