package com.dandan.work.handler.api;

import com.dandan.work.handler.api.acceptance.AcceptanceItems;
import com.dandan.work.handler.api.bo.CancelOrderBO;
import com.dandan.work.handler.api.bo.ModifyProblemBO;
import com.dandan.work.handler.api.problem.Problem;

import java.util.List;

/**
 * Created by dandan On 十月 09 2019
 */
public interface JYHandler {

    /**
     * 批量清除工单缓存
     * @param orderId 工单号
     */
    public void clearOrderCache(String orderId) throws Exception;


    /**
     * 获取工单验收项
     * @param orderId 工单号
     * @return
     * @throws Exception
     */
    List<AcceptanceItems> getAcceptanceItems(String orderId) throws Exception;


    /**
     * 修改为质保
     * @param orderId 工单号
     * @param acceptanceItems 验收项
     * @throws Exception
     */
    public void completeAcceptance(String orderId, List<AcceptanceItems> acceptanceItems) throws Exception;


    public void cancelOrder(CancelOrderBO req) throws Exception;

    Problem searchProblem(String problemId) throws Exception;

    void modifyProblem(ModifyProblemBO req) throws Exception;

    /**
     * 初始化历史工单师傅最低价
     */
    void initOrderLowIncomeStatist() throws Exception;

}
