package com.dandan.work.service;

import com.dandan.common.utils.files.ImportFileUtils;
import com.dandan.work.handler.WXHandlerImpl;
import com.dandan.work.handler.api.WXHandler;
import com.dandan.work.handler.api.WeiXinMessagePraiseAuditRequest;
import org.junit.Test;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-10
 */
public class WXServiceCall {

    private WXHandler wxHandler = new WXHandlerImpl();

    /**
     * 推送客户好评有奖模版消息
     * @throws Exception
     */
    @Test
    public void pushWeixinPraiseAuditMessage() throws Exception{
        List<List<String>> lists = ImportFileUtils.readExcel("/Users/dandan/Documents/import_files/customerPraise.xlsx");
        for (List<String> list : lists) {
            WeiXinMessagePraiseAuditRequest req = new WeiXinMessagePraiseAuditRequest();
            req.setOpenId(list.get(1));
            req.setOrderId(list.get(0));
            System.out.println(req.toString());
            wxHandler.pushWeixinPraiseAuditMessage(req);

            //curl 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxcf92bd997aff0570&secret=8fa0bf211b5ddee43a5a2b26353a6ba1'
            //curl 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxa9ac9ffaf4610bcd&secret=13959fc51cf4c33939cf09cf1aa886ff'

            // curl 'https://'
        }
        System.out.println(lists.size());
    }



}
