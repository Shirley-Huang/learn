package com.dandan.work.handler;

import com.alibaba.fastjson.JSON;
import com.dandan.common.utils.HttpClientUtils02;
import com.dandan.work.consts.JYRequestParameters;
import com.dandan.work.handler.api.JYHandler;
import com.dandan.work.handler.api.acceptance.AcceptanceItems;
import com.dandan.work.handler.api.acceptance.OrderAcceptanceItemsResponse;
import com.dandan.work.consts.ContentType;
import com.dandan.work.consts.MethodType;
import com.dandan.work.handler.api.bo.CancelOrderBO;
import com.dandan.work.handler.api.bo.ModifyProblemBO;
import com.dandan.work.handler.api.problem.Problem;
import com.dandan.work.handler.api.problem.SearchProblemsResponse;

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
        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.CLEAR_ORDER_CACHE_REQUEST_URL;
        String contentType = ContentType.APPLICATION_FORM_URLENCODED;
        String methodType = MethodType.POST;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orderId",orderId);

        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(orderId + "——" + result);

    }

    @Override
    public List<AcceptanceItems> getAcceptanceItems(String orderId) throws Exception {
        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.GET_ACCEPTANCE_ITEMS_REQUEST_URL;
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
        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.COMPLETE_ACCEPTANCE_REQUEST_URL;
        String contentType = ContentType.APPLICATION_JSON_UTF8;
        String methodType = MethodType.POST;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orderId",orderId);
        data.put("acceptanceItems",acceptanceItems);
        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(orderId + "——" + result);

    }

    @Override
    public void cancelOrder(CancelOrderBO req) throws Exception {

        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.CANCEL_ORDER_REQUEST_URL;
        String contentType = ContentType.APPLICATION_JSON_UTF8;
        String methodType = MethodType.POST;
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("orderId", req.getOrderId());
        data.put("orderCancelDemander", req.getOrderCancelDemander());
        data.put("cancelReasonTypeCode", req.getCancelReasonTypeCode());
        data.put("cancelReasonDescription", req.getCancelReasonDescription());
        data.put("ignoreVerify", req.getIgnoreVerify());
        data.put("verifyCode", req.getVerifyCode());
        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(req.getOrderId() + "——" + result);
    }

    private String sendRequest(String requestUrl, String contentType, String methodType, Map<String, Object> data) throws Exception{
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Cookie", JYRequestParameters.COOKIE);
        headers.put("Content-Type", contentType);
        headers.put("jiangyun-device", "BROWSER");
        return HttpClientUtils02.requestString(requestUrl, headers, data, methodType);
    }

    @Override
    public Problem searchProblem(String problemId) throws Exception {
        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.SEARCH_PROBLEM_INFO_REQUEST_URL;
        String contentType = ContentType.APPLICATION_FORM_URLENCODED_UTF8;
        String methodType = MethodType.POST;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id",problemId);
        String result = sendRequest(requestUrl,contentType, methodType, data);
        //System.out.println(orderId + "——" + result);

        SearchProblemsResponse response = JSON.parseObject(result, SearchProblemsResponse.class);
        Problem problem = null;
        if(response.getProblems() != null && response.getProblems().size() > 0){
            problem = response.getProblems().get(0);
        }
        return problem;
    }

    @Override
    public void modifyProblem(ModifyProblemBO req) throws Exception {
        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.MODIFY_PROBLEM_REQUEST_URL;
        String contentType = ContentType.APPLICATION_JSON_UTF8;
        String methodType = MethodType.POST;

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", req.getId());
        data.put("problemStatusId", req.getProblemStatusId());
        data.put("problemCategoryId", req.getProblemCategoryId());
        data.put("problemFirstCategoryId", req.getProblemFirstCategoryId());
        data.put("problemFirstCategoryName", req.getProblemFirstCategoryName());
        data.put("problemSecondCategoryId", req.getProblemSecondCategoryId());
        data.put("problemSecondCategoryName", req.getProblemSecondCategoryName());
        data.put("tomorrowDeal", req.getTomorrowDeal());
        data.put("complaintRisk", req.getComplaintRisk());
        data.put("complaintsOrder", req.getComplaintsOrder());
        data.put("customerReminder", req.getCustomerReminder());
        data.put("signCount", req.getSignCount());
        data.put("complaintChannel", req.getComplaintChannel());
        data.put("notePictures", req.getNotePictures());

        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(req.getId() + "——" + result);

    }

    @Override
    public void initOrderLowIncomeStatist() throws Exception {
        String requestUrl = JYRequestParameters.OPS_DOMAIN + JYRequestParameters.INIT_ORDER_LOW_INCOME_REQUEST_URL;
        String contentType = ContentType.APPLICATION_JSON_UTF8;
        String methodType = MethodType.GET;
        Map<String, Object> data = new HashMap<String, Object>();
        String result = sendRequest(requestUrl,contentType, methodType, data);
        System.out.println(result);;
    }

}
