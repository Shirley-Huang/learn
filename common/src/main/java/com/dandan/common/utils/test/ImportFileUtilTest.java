package com.dandan.common.utils.test;

import com.dandan.common.utils.files.ImportFileUtils;

import java.util.List;

/**
 * Created by dandan On 十月 09 2019
 */
public class ImportFileUtilTest {

    public void readExcelTest(){
        List<List<String>> lists = ImportFileUtils.readExcel("/Users/dandan/Documents/数据库sql查询/大鱼米家工单同步状态/匠云昨天核销工单.xlsx");

        //行数据
        for (List<String> list : lists) {
            //列数据
            String firstCell = list.get(0);
            System.out.println(firstCell);
        }

    }

    public void readTextTest(){
        List<String> strings = ImportFileUtils.readText("/Users/dandan/1.txt");
        for (String string : strings) {
            System.out.println(string);
        }
    }



}
