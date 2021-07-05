package com.dandan.work.handler;

import com.alibaba.fastjson.JSON;
import com.dandan.common.utils.HttpClientUtils02;
import com.dandan.common.utils.StringUtils;
import com.dandan.work.consts.ContentType;
import com.dandan.work.consts.MethodType;
import com.dandan.work.consts.WXRequestParameters;
import com.dandan.work.handler.api.MassSendMessageRequest;
import com.dandan.work.handler.api.WXHandler;
import com.dandan.work.handler.api.WeiXinMessagePraiseAuditRequest;
import com.dandan.work.handler.api.message.template.PraiseAwardMessageTemplate;
import com.dandan.work.handler.api.message.template.WeixinTemplateMessageRO;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-10
 */
public class WXHandlerImpl implements WXHandler {

    public static String env = "ONLINE";

    private static String weixinClientId;
    private static String weixinClientKey;

    static {
    }

    @Override
    public void pushWeixinPraiseAuditMessage(WeiXinMessagePraiseAuditRequest req) throws Exception {

        String praiseAwardTemplateId_online = "CFePP-DmiaPTdC9KzodDG-CnS6SEd_ZI9e1Lh3Wj1FU";
        String praiseAwardTemplateId_test01 = "ef9wlv8c5BkH6d3wTkoiYUG3nNshboDpKXvd_FQobgM";
        String praiseAwardTemplateId = praiseAwardTemplateId_online;

        String weixinId_online = "gh_b95cf4453e22";
        String weixinId_test01 = "gh_95aba09007c8";
        String weixinId = weixinId_online;


        String openId = req.getOpenId();
        String orderSummary = "上门安装";
        String customerPraiseAwardAmount = (req.getPrice() == null || req.getPrice().length() <= 0) ? "10" :req.getPrice();
        String auditStatus = "欢迎参加“好评有奖”活动：上传在购买渠道（如京东、天猫、小米有品等）上的“五星+文字”好评后截图可获得公众号直接发送的10元～30元微信现金红包！上传方法：请点击“匠云智慧生活”公众号页面左下角“好评有奖”按钮，加载完成后直接上传购买店铺“五星+文字”好评的页面截图即可，谢谢！";
        String url = WXRequestParameters.OPS_CUSTOMER_SERVER_URL + "/workOrder/award.html?orderId=" + req.getOrderId() + "&WXCode=" + weixinId;
        PraiseAwardMessageTemplate template = new PraiseAwardMessageTemplate(praiseAwardTemplateId, openId, orderSummary, auditStatus, url);

        String paramStr = JSON.toJSONString(template.toMessage());
//        System.out.println(paramStr);
        Map params = JSON.parseObject(paramStr, Map.class);
        String result = sendRequest(WXRequestParameters.SEND_TEMPLATE_MESSAGE_REQUEST_URL, MethodType.POST, params);
        System.out.println(result);
    }

    @Override
    public void sendMassMessage(MassSendMessageRequest request) throws Exception {

        Map<String, Object> data = new HashMap<>();

        Map<String,String> content = new HashMap<>();

        if("text".equals(request.getMsgType()) && !StringUtils.isEmpty(request.getContent())){
            content.put("content",request.getContent());
        }else if ("mpnews".equals(request.getMsgType()) && !StringUtils.isEmpty(request.getMediaId())){
            content.put("media_id",request.getMediaId());
            data.put("send_ignore_reprint",0);
        }else{
            return;
        }

        data.put(request.getMsgType(),content);
        data.put("msgtype",request.getMsgType());
        data.put("touser",request.getOpenIds());

        String result = sendRequest(WXRequestParameters.SEND_MASS_MESSAGE_REQUEST_URL, MethodType.POST, data);
        System.out.println(result);
    }


    private String sendRequest(String requestUrl, String methodType, Map<String, Object> data) throws Exception{
        String accessToken = WXRequestParameters.ACCESS_TOKEN;
        requestUrl = requestUrl.replace("ACCESS_TOKEN", accessToken);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Content-Type", ContentType.APPLICATION_JSON_UTF8);
        return HttpClientUtils02.requestString(requestUrl, headers, data, methodType);
    }

    public String getWeiXinAccessToken() throws Exception{
        String weixinClientId_online = "wxa9ac9ffaf4610bcd";
        String weixinClientId_test01 = "wxcf92bd997aff0570";
        String weixinClientId = weixinClientId_test01;


        String weixinClientKey_online = "13959fc51cf4c33939cf09cf1aa886ff";
        String weixinClientKey_test01 = "8fa0bf211b5ddee43a5a2b26353a6ba1";
        String weixinClientKey = weixinClientKey_test01;
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("grant_type", "client_credential");
        params.put("appid", weixinClientId);

        params.put("secret", weixinClientKey);

        String url = WXRequestParameters.GET_ACCESS_TOEKN_REQUEST_URL;
        String result = sendRequest(url, MethodType.POST, params);
        System.out.println(result);
        HashMap<String, Object> values = JSON.parseObject(result,HashMap.class);
        if(values.containsKey("errcode")){
            return null;
        }
        return values.get("access_token").toString();
    }

}
