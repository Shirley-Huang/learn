package com.dandan.work.service;

import com.dandan.common.utils.files.ImportFileUtils;
import com.dandan.work.handler.WXHandlerImpl;
import com.dandan.work.handler.api.MassSendMessageRequest;
import com.dandan.work.handler.api.WXHandler;
import com.dandan.work.handler.api.WeiXinMessagePraiseAuditRequest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            req.setOrderId(list.get(0));
            req.setOpenId(list.get(1));
            System.out.println(req.toString());
            wxHandler.pushWeixinPraiseAuditMessage(req);

            //curl 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxcf92bd997aff0570&secret=8fa0bf211b5ddee43a5a2b26353a6ba1'
            //curl 'https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wxa9ac9ffaf4610bcd&secret=13959fc51cf4c33939cf09cf1aa886ff'

            // curl 'https://'
//            break;
        }
        System.out.println(lists.size());
    }

    /**
     * 上传图片
     */


    /**
     * 上传图文素材
     */
    @Test
    public void uploadMpNews() throws Exception{

        Map<String,Object> article = new HashMap<>();
        article.put("thumb_media_id","");//图文消息缩略图，可在素材管理-新增素材中获取
        article.put("author","黄丹丹");//作者
        article.put("title","");//标题
        article.put("content_source_url","");//图文消息页面点击阅读原文后的页面
        article.put("content","");//图文消息页面的内容
        article.put("digest","");//图文消息的描述，为空则抓取正文前64个字
        article.put("show_cover_pic",1);//是否显示封面，1为显示，0不显示
        article.put("need_open_comment",0);//是否打开评论，0不打开，1打开
        article.put("only_fans_can_comment",1);//粉丝是否可评论，0可评论，1不可评论

        Map<String,Map> data = new HashMap<>();
        data.put("articles",article);


    }

    /**
     * 群发消息
     */
    @Test
    public void massSendMessage() throws Exception{
        /**
         * https://developers.weixin.qq.com/doc/offiaccount/Asset_Management/Get_materials_list.html
         * 第一步：通过【素材管理】-【获取素材列表】获取图文id
         *        http请求方式: POST https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN
         * 请求参数{
         *          "type":"news",
         *          "offset":0,
         *          "count":20
         *         }
         *  响应  "media_id":"VK7lpdnGZwbxgjD_n9aX5C5jnyD4GHvLHM8XSFb5PV8"
         */

        /**
         * 第二步：【消息管理】-【群发接口和原创校验】-【根据OpenID列表群发】
         *
         *
         *
         *
         */



        List<List<String>> lists = ImportFileUtils.readExcel("/Users/dandan/Documents/import_files/customerPraise.xlsx");

        int i = 0;
        List<String> openIds = new ArrayList<>();
        for (List<String> list : lists) {
//            if(i++ == 2){
//                break;
//            }
            openIds.add(list.get(1));
        }
        System.out.println(openIds);


        MassSendMessageRequest request = new MassSendMessageRequest();
        request.setOpenIds(openIds);
//        request.setMediaId("SPrWr1E1zYLaBRQMdvYUT66Exy27UzgDBpz3Rv0Ly_0");
        request.setMediaId("SPrWr1E1zYLaBRQMdvYUT2KJ4pY3UJ1CQy-OTxAlPxE");
        request.setMsgType("mpnews");
        request.setSendIgnoreReprint(0);


        MassSendMessageRequest request1 = new MassSendMessageRequest();
        request1.setOpenIds(openIds);
        request1.setMsgType("text");
        request1.setContent("欢迎参加“好评有奖”活动：上传在购买渠道（如京东、天猫、小米有品等）上的“五星+文字”好评后截图可获得公众号直接发送的10元～30元微信现金红包！上传方法：请点击“匠云智慧生活”公众号页面左下角“好评有奖”按钮，加载完成后直接上传购买店铺“五星+文字”好评的页面截图即可，谢谢！");


        wxHandler.sendMassMessage(request);



    }



}
