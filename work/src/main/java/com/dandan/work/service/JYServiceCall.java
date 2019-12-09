package com.dandan.work.service;

import com.dandan.common.utils.files.ImportFileUtils;
import com.dandan.work.handler.JYHandlerImpl;
import com.dandan.work.handler.api.JYHandler;
import com.dandan.work.handler.api.acceptance.AcceptanceItems;
import com.dandan.work.handler.api.bo.CancelOrderBO;
import com.dandan.work.handler.api.bo.ModifyProblemBO;
import com.dandan.work.handler.api.problem.Problem;
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
     * 已核销工单修改质保
     */
    @Test
    public void completeAcceptanceForAlreadyVerify() throws Exception{
        List<List<String>> lists = ImportFileUtils.readExcel("/Users/dandan/Documents/import_files/verifyOrderComplete.xlsx");
        List<String> sqls = new ArrayList<>();
        for (List<String> list : lists) {
            String orderId = list.get(0);
            //1、获取该工单验收项
            List<AcceptanceItems> acceptanceItems = jyHandlerImpl.getAcceptanceItems(orderId);

            //2、修改为质保
            jyHandlerImpl.completeAcceptance(orderId,acceptanceItems);

            //生成sql语句
            String sql = "UPDATE `jiangyun_ops`.`t_order` SET `partner_order_number` = " + list.get(1) + " WHERE (`id` = " + orderId  + ");";
            sqls.add(sql);
        }

        for (String sql : sqls) {
            System.out.println(sql);
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

    /**
     * 取消工单
     */
    @Test
    public void cancelOrder2() throws Exception{
        //1、从指定路径的文件中读取工单id
        List<List<String>> lists = ImportFileUtils.readExcel("/Users/dandan/Documents/import_files/cancelOrderIds2.xlsx");

        //行数据
        for (List<String> list : lists) {
            //列数据
            CancelOrderBO req = new CancelOrderBO();
            req.setOrderId(list.get(0));
            req.setOrderCancelDemander("MERCHANT");
            req.setCancelReasonTypeCode("CUSTOMER_NOT_INSTALL_TEMPORARILY");
            req.setCancelReasonDescription("客户暂不安装");
            req.setVerifyCode(list.get(1));
            jyHandlerImpl.cancelOrder(req);
//            break;
        }
        System.out.println(lists.size());

    }

    /**
     * 批量将当前问题修改为已完结
     */
    @Test
    public void modifyProblme() throws Exception{

        //查询问题id
        List<String> problemIds = ImportFileUtils.readText("/Users/dandan/Documents/import_files/problemIds.txt");
        //遍历
        for (String problemId : problemIds) {
            //获取问题的信息
            Problem problem = jyHandlerImpl.searchProblem(problemId);
            if(problem == null){
                System.out.println("问题查询结果为空");
                continue;
            }
            //将问题完结
            ModifyProblemBO req = fillModifyProblemInfo(problem);
            jyHandlerImpl.modifyProblem(req);

        }




    }

    private ModifyProblemBO fillModifyProblemInfo(Problem problem) {
        ModifyProblemBO bo = new ModifyProblemBO();
        bo.setId(problem.getId());
        bo.setTomorrowDeal(problem.getTomorrowDeal());
        bo.setProblemStatusId(3);
        bo.setProblemCategoryId(problem.getProblemCategoryId());
        bo.setProblemFirstCategoryId(problem.getProblemFirstCategoryId());
        bo.setProblemFirstCategoryName(problem.getProblemFirstCategoryName());
        bo.setProblemSecondCategoryId(problem.getProblemSecondCategoryId());
        bo.setProblemSecondCategoryName(problem.getProblemSecondCategoryName());
        bo.setComplaintRisk(problem.getComplaintRisk());
        bo.setSignCount(problem.getSignCount());
        bo.setComplaintsOrder(problem.getComplaintsOrder());
        bo.setCustomerReminder(problem.getCustomerReminder());
        bo.setComplaintChannel(problem.getComplaintChannel());
        bo.setNotePictures(problem.getNotePictures());
        return bo;
    }

}
