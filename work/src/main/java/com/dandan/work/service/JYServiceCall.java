package com.dandan.work.service;

import com.dandan.common.utils.files.ImportFileUtils;
import com.dandan.work.handler.JYHandlerImpl;
import com.dandan.work.handler.api.JYHandler;
import com.dandan.work.handler.api.acceptance.AcceptanceItems;
import com.dandan.work.handler.api.bo.CancelOrderBO;
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

    /**
     * 取消工单
     */
    @Test
    public void cancelOrder() throws Exception{
        //1、从指定路径的文件中读取工单id
        List<String> orderIds = ImportFileUtils.readText("/Users/dandan/Documents/import_files/orderIds.txt");
        for (String orderId : orderIds) {
            CancelOrderBO req = new CancelOrderBO();
            req.setOrderId(orderId);
            req.setOrderCancelDemander("MERCHANT");
            req.setCancelReasonTypeCode("CUSTOMER_NOT_INSTALL_TEMPORARILY");
            req.setCancelReasonDescription("客户暂不安装");
            req.setIgnoreVerify(true);
            req.setVerifyCode("0000");
            jyHandlerImpl.cancelOrder(req);
        }
        System.out.println(orderIds.size());

    }


}
