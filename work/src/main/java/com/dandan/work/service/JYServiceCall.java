package com.dandan.work.service;

import com.dandan.common.utils.ImportFileUtils;
import com.dandan.work.handler.JYHandlerImpl;
import com.dandan.work.handler.api.JYHandler;
import com.dandan.work.handler.api.acceptance.AcceptanceItems;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by dandan On 十月 09 2019
 * 匠云服务调用
 */
public class JYServiceCall {

    private JYHandler jyHandlerImpl = new JYHandlerImpl();

    /**
     * 批量清理缓存
     */
    @Test
    public void batchClearOrderCache(){
        //1、从指定路径的文件中读取工单id
        List<String> orderIds = ImportFileUtils.readText("/Users/dandan/Documents/import_files/orderIds.txt");
        for (String orderId : orderIds) {
            try {
                jyHandlerImpl.clearOrderCache(orderId);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 修改为质保
     */
    @Test
    public void completeAcceptance() throws Exception{

        //1、从指定路径的文件中读取工单id
        List<String> orderIds = ImportFileUtils.readText("/Users/dandan/Documents/import_files/orderIds.txt");

        for (String orderId : orderIds) {

            //1、获取该工单验收项
            List<AcceptanceItems> acceptanceItems = jyHandlerImpl.getAcceptanceItems(orderId);

            //2、修改为质保
            jyHandlerImpl.completeAcceptance(orderId,acceptanceItems);

        }

    }


}
