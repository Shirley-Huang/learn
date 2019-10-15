package com.dandan.work.handler;

import com.alibaba.fastjson.JSON;
import com.dandan.common.utils.HttpClientUtils02;
import com.dandan.work.consts.Parameters;
import com.dandan.work.handler.api.JYHandler;
import com.dandan.work.handler.api.acceptance.AcceptanceItems;
import com.dandan.work.handler.api.acceptance.OrderAcceptanceItemsResponse;
import com.dandan.work.consts.ContentType;
import com.dandan.work.consts.MethodType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dandan On 十月 09 2019
 */
public class JYHandlerImpl implements JYHandler {


    @Override
    public void clearOrderCache(String orderId) throws Exception {
        String requestUrl = Parameters.OPS_DOMAIN + Parameters.CLEAR_ORDER_CACHE_REQUEST_URL;
        String contentType = ContentType.APPLICATION_FORM_URLENCODED;
        String methodType = MethodType.POST;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orderId",orderId);

        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(orderId + "——" + result);

    }

    @Override
    public List<AcceptanceItems> getAcceptanceItems(String orderId) throws Exception {
        String requestUrl = Parameters.OPS_DOMAIN + Parameters.GET_ACCEPTANCE_ITEMS_REQUEST_URL;
        String contentType = ContentType.APPLICATION_JSON_UTF8;
        String methodType = MethodType.GET;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orderId",orderId);
        String result = sendRequest(requestUrl,contentType, methodType, data);
        //System.out.println(orderId + "——" + result);

        OrderAcceptanceItemsResponse response = JSON.parseObject(result, OrderAcceptanceItemsResponse.class);
        List<AcceptanceItems> acceptanceItems = new ArrayList<>();
        if(response.getOrderAcceptanceItems() != null){
            acceptanceItems = response.getOrderAcceptanceItems().get(0).getAcceptanceItems();
        }
        return acceptanceItems;
    }

    @Override
    public void completeAcceptance(String orderId, List<AcceptanceItems> acceptanceItems) throws Exception{
        String requestUrl = Parameters.OPS_DOMAIN + Parameters.COMPLETE_ACCEPTANCE_REQUEST_URL;
        String contentType = ContentType.APPLICATION_JSON_UTF8;
        String methodType = MethodType.POST;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orderId",orderId);
        data.put("acceptanceItems",acceptanceItems);
        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(orderId + "——" + result);

    }

    private String sendRequest(String requestUrl,String contentType,String methodType,Map<String, Object> data) throws Exception{
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", Parameters.COOKIE);
        headers.put("Content-Type", contentType);
        headers.put("jiangyun-device", "BROWSER");
        return HttpClientUtils02.requestString(requestUrl, headers, data, methodType);
    }

}
