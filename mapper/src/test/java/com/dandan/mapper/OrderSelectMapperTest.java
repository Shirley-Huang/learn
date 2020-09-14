package com.dandan.mapper;

import com.dandan.common.model.pojo.TimeRange;
import com.dandan.common.utils.DateTimeUtility;
import com.dandan.common.utils.files.ExportFileUtils;
import com.dandan.common.utils.files.rowModel.OrderArtisanIncomeAmountModel;
import com.dandan.common.utils.files.rowModel.TakeOrderTimeModel;
import com.dandan.model.pojo.jiangyun.*;
import com.dandan.model.pojo.jiangyun.filter.ArtisanIncomeFilter;
import com.dandan.model.pojo.jiangyun.filter.TakeOrderTimeFilter;
import com.dandan.model.pojo.jiangyun.result.OrderArtisanIncome;
import com.dandan.model.pojo.jiangyun.result.OrderPartsInfo;
import com.dandan.model.pojo.jiangyun.result.TakeOrderTime;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderSelectMapperTest{


    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderSelectMapper orderSelectMapper;

    @Test
    public void selectOrder(){
        List<Order> orders = orderMapper.selectOrderLimit();
        System.out.println("控制台打印");

//        List<List<String>> datas = new ArrayList<>();
//        for (Order order : orders) {
//            List<String> data = new ArrayList<>();
//            data.add(order.getOrderId());
//            data.add(order.getPartnerOrderNum());
//            data.add(order.getStatusId().toString());
//            data.add(order.getMerchantId());
//            data.add(order.getMerchantName());
//            data.add(order.getArtisanName());
//            data.add(order.getArtisanMobile());
//            datas.add(data);
//        }
//        String fileName = "/Users/dandan/Documents/import_files/工单列表.xlsx";
//        ExportFileUtils.writeExcel(datas,fileName, SheetModel.class);
    }

    /**
     * 效率太差，不建议使用，数据量多时数据库连接数直线上升
     * 求接单均单时长
     * @throws Exception
     */
    @Test
    public void selectTakeOrderTime() throws Exception{

        String fromStr = "2019-10-01";
        String toStr = "2019-11-01";

        TakeOrderTimeFilter takeOrderTimeFilter = new TakeOrderTimeFilter();
        takeOrderTimeFilter.setOrecStatusCode("WAITING_CONTACT_CUSTOMER");
        takeOrderTimeFilter.setOscStatusCode("WAITING_CONTACT_CUSTOMER");
        takeOrderTimeFilter.setOrecExcludeEmployeeId("169");

        Date from = DateTimeUtility.parseYYYYMMDD(fromStr);
        Date to = DateTimeUtility.parseYYYYMMDD(toStr);
        takeOrderTimeFilter.setOscCreateTime(new TimeRange(from, to));

        List<String> orderIds = orderSelectMapper.selectOrderIdsByFilter(takeOrderTimeFilter);
        if(true){
            throw new RuntimeException();
        }
//        List<String> orderIds = new ArrayList<>();
//        orderIds.add("1393401");
//        orderIds.add("1392980");
//        orderIds.add("1391916");
//        orderIds.add("1392553");

        List<List<String>> datas = new ArrayList<>();
        for (String orderId : orderIds) {
            List<String> data = new ArrayList<>();
            TakeOrderTime order = orderSelectMapper.selectOrderByOrderId(orderId);
            if(order == null){
                continue;
            }

            //待联系客户状态第一次分配客服的时间
            Date firstContactCustomerCreateTime = null;
            Date fistGrabingCreateTime = null;
            String employeeName = "";
            boolean hasFirstContactCustomerFlag = false;
            for (OrderResponsibilityEmployeeContrail employeeContrail : order.getEmployeeContrails()) {
                if(employeeContrail.getOrderStatusCode().equals("WAITING_CONTACT_CUSTOMER") && !hasFirstContactCustomerFlag){
                    firstContactCustomerCreateTime = employeeContrail.getCreateTime();
                    employeeName = employeeContrail.getEmployeeName();
                    hasFirstContactCustomerFlag = true;
                }
                if(employeeContrail.getOrderStatusCode().equals("WAITING_GRAB") && hasFirstContactCustomerFlag){
                    fistGrabingCreateTime = employeeContrail.getCreateTime();
                    break;
                }
            }

            //第一次抢单时间
            Date fistGrabingTime = new Date();
            Date grabingTime = new Date();
            OrderProperty orderProperty = order.getOrderProperty();
            if(orderProperty != null && orderProperty.getFirstGrabTime() != null){
                fistGrabingTime = orderProperty.getFirstGrabTime();
                grabingTime = fistGrabingTime;
            }

            if(fistGrabingCreateTime != null){
                System.out.println("相差的秒数------------=" +DateTimeUtility.secondBetween(firstContactCustomerCreateTime,grabingTime));
                if(DateTimeUtility.secondBetween(firstContactCustomerCreateTime,grabingTime) <= 0){
                    System.out.println("小于等于0");
                    grabingTime = fistGrabingCreateTime;
                }
            }

            //总时长
            Integer allEmployeeProcessdurationSecond = DateTimeUtility.secondBetween(firstContactCustomerCreateTime,grabingTime);
            //非客服处理时长
            Integer notEmployeeProcessDurationSecond = 0;
            if(orderProperty != null && orderProperty.getNotEmployeeProcessDurationSecond() != null){
                notEmployeeProcessDurationSecond = orderProperty.getNotEmployeeProcessDurationSecond();
            }
            //客服处理时长
            Integer processDurationSecond = allEmployeeProcessdurationSecond - notEmployeeProcessDurationSecond;

            data.add(orderId);
            data.add(order.getMerchantName());
            data.add(DateTimeUtility.formatYYYYMMDDHHMMSS(firstContactCustomerCreateTime));
            data.add(employeeName);
            data.add(DateTimeUtility.formatYYYYMMDDHHMMSS(fistGrabingTime));
            data.add(DateTimeUtility.formatYYYYMMDDHHMMSS(fistGrabingCreateTime));
            data.add(allEmployeeProcessdurationSecond.toString());
            data.add(notEmployeeProcessDurationSecond.toString());
            data.add(processDurationSecond.toString());

            datas.add(data);
        }
        String fileName = "/Users/dandan/Documents/import_files/接单均单时长.xlsx";
        ExportFileUtils.writeExcel(datas,fileName, TakeOrderTimeModel.class);
    }

    /**
     * 求接单均单时长
     * @throws Exception
     */
    @Test
    public void selectTakeOrderTime2() throws Exception{

        String fromStr = "2019-10-01";
        String toStr = "2019-11-01";
        Date from = DateTimeUtility.parseYYYYMMDD(fromStr);
        Date to = DateTimeUtility.parseYYYYMMDD(toStr);
        TimeRange timeRange = new TimeRange(from, to);

        TakeOrderTimeFilter takeOrderTimeFilter = new TakeOrderTimeFilter();
        takeOrderTimeFilter.setOrecStatusCode("WAITING_CONTACT_CUSTOMER");
        takeOrderTimeFilter.setOscStatusCode("WAITING_CONTACT_CUSTOMER");
        takeOrderTimeFilter.setOrecExcludeEmployeeId("169");
        takeOrderTimeFilter.setOscCreateTime(timeRange);



        List<TakeOrderTime> orders = orderSelectMapper.selectTakeOrderTimeOrdersByFilter(takeOrderTimeFilter);

        long startForEachTime = System.currentTimeMillis();
        List<List<String>> datas = new ArrayList<>();
        for (TakeOrderTime order : orders) {
            List<String> data = new ArrayList<>();
            if(order == null){
                continue;
            }

            //待联系客户状态第一次分配客服时间
            Date firstContactCustomerCreateTime = null;
            boolean hasFirstContactCustomerFlag = false;
            //客服姓名
            String employeeName = "";
            //第一次抢单时间
            //待联系客户状态后面的第一个待抢单时间
            Date fistGrabingCreateTime = null;

            for (OrderResponsibilityEmployeeContrail employeeContrail : order.getEmployeeContrails()) {
                //如果责任客服不是机器人客服
                if(employeeContrail.getOrderStatusCode().equals("WAITING_CONTACT_CUSTOMER") && !employeeContrail.getEmployeeId().equals("169") && !hasFirstContactCustomerFlag){
                    firstContactCustomerCreateTime = employeeContrail.getCreateTime();
                    employeeName = employeeContrail.getEmployeeName();
                    hasFirstContactCustomerFlag = true;
                }
                if(employeeContrail.getOrderStatusCode().equals("WAITING_GRAB") && hasFirstContactCustomerFlag){
                    fistGrabingCreateTime = employeeContrail.getCreateTime();
                    break;
                }
            }
            if(!hasFirstContactCustomerFlag){
                continue;
            }

            //第一次抢单时间
            Date fistGrabingTime = new Date();
            OrderProperty orderProperty = order.getOrderProperty();
            if(orderProperty != null && orderProperty.getFirstGrabTime() != null){
                fistGrabingTime = orderProperty.getFirstGrabTime();
            }

            Date grabingTime = new Date();
            //如果第一次抢单时间小于第一次分配待联系客户状态客服时间，则是机器人派单，待联系客户状态后面的第一个待抢单时间
            if(DateTimeUtility.secondBetween(firstContactCustomerCreateTime,fistGrabingTime) <= 0 && fistGrabingCreateTime != null){
                grabingTime = fistGrabingCreateTime;
            }else{
                grabingTime = fistGrabingTime;
            }

            //总时长
            Integer allEmployeeProcessdurationSecond = DateTimeUtility.secondBetween(firstContactCustomerCreateTime,grabingTime);
            //非客服处理时长
            Integer notEmployeeProcessDurationSecond = 0;
            if(orderProperty != null && orderProperty.getNotEmployeeProcessDurationSecond() != null){
                notEmployeeProcessDurationSecond = orderProperty.getNotEmployeeProcessDurationSecond();
            }
            //客服处理时长
            Integer processDurationSecond = allEmployeeProcessdurationSecond - notEmployeeProcessDurationSecond;

            data.add(order.getOrderId());
            data.add(order.getMerchantName());
            data.add(DateTimeUtility.formatYYYYMMDDHHMMSS(firstContactCustomerCreateTime));
            data.add(employeeName);
            data.add(DateTimeUtility.formatYYYYMMDDHHMMSS(fistGrabingTime));
            data.add(DateTimeUtility.formatYYYYMMDDHHMMSS(fistGrabingCreateTime));
            data.add(allEmployeeProcessdurationSecond.toString());
            data.add(notEmployeeProcessDurationSecond.toString());
            data.add(processDurationSecond.toString());

            datas.add(data);
        }
        System.out.println("for遍历结果集使用毫秒数：" + (System.currentTimeMillis() - startForEachTime));
        String fileName = "/Users/dandan/Documents/import_files/接单均单时长04.xlsx";
        ExportFileUtils.writeExcel(datas,fileName, TakeOrderTimeModel.class);
    }

    @Test
    public void selectOrderArtisanIncomeInfo() throws Exception{

        String fromStr = "2020-03-01";
        String toStr = "2020-04-01";
        Date from = DateTimeUtility.parseYYYYMMDD(fromStr);
        Date to = DateTimeUtility.parseYYYYMMDD(toStr);
        TimeRange timeRange = new TimeRange(from, to);

        ArtisanIncomeFilter filter = new ArtisanIncomeFilter();
        filter.setStatusId(1);
//        filter.setCategoryServingName("安装");
        filter.setCompletedTime(timeRange);
//        filter.setOrderId("1392572");
        List<OrderArtisanIncome> orderArtisanInfos = orderSelectMapper.selectOrderArtisanIncomeByFilter(filter);

        System.out.println(orderArtisanInfos.size());//17413  11847
        List<List<String>> datas = new ArrayList<>();
        for (OrderArtisanIncome orderArtisanInfo : orderArtisanInfos) {
            List<String> data = new ArrayList<>();
            Order order = orderArtisanInfo.getOrder();
            String artisanType = "";
            if(StringUtils.isNotBlank(order.getArtisanLeaderTypeCode())){
                if(order.getArtisanLeaderTypeCode().equals("SERVICE_PROVIDER_ARTISAN")){
                    artisanType = "服务商";
                }else if(order.getArtisanLeaderTypeCode().equals("COMPANY_OWNED_ARTISAN")){
//                    artisanType = "直营";
                    continue;
                }
            }else if(order.getTeamOrder().getValue()){
                artisanType = "合伙人";
            }else {
                artisanType = "众包";
            }

            boolean earlyCompleteOrder = false;
            if(StringUtils.isNotBlank(order.getEmployeeNote()) && order.getEmployeeNote().contains("【系统】提前结束工单")){
                earlyCompleteOrder = true;
                continue;
            }

            List<OrderProduct> orderProducts = orderArtisanInfo.getOrderProducts();
            String categoryServingName = "安装";
            Integer productNumber = 0;
            String productName = "";
            for (OrderProduct orderProduct : orderProducts) {
                categoryServingName = orderProduct.getCategoryServingName();
                productNumber += orderProduct.getNumber();
                productName = orderProduct.getName();
            }

            if(productNumber > 20){
                continue;
            }

            List<OrderArtisanRewardPunishment> rewardPunishments = orderArtisanInfo.getRewardPunishments();
            BigDecimal a1 = BigDecimal.ZERO;
            BigDecimal a2 = BigDecimal.ZERO;
            BigDecimal a3 = BigDecimal.ZERO;
            BigDecimal a4 = BigDecimal.ZERO;
            BigDecimal a5 = BigDecimal.ZERO;
            BigDecimal a6 = BigDecimal.ZERO;
            BigDecimal a7 = BigDecimal.ZERO;
            BigDecimal a8 = BigDecimal.ZERO;
            BigDecimal a9 = BigDecimal.ZERO;
            BigDecimal a10 = BigDecimal.ZERO;
            BigDecimal a11 = BigDecimal.ZERO;
            for (OrderArtisanRewardPunishment rewardPunishment : rewardPunishments) {
                if(rewardPunishment.getCode().contains("CUSTOMER_SATISFIED")){
                    a1 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("OJJ_TAKINGGOODS_ORDER_ARTISAN_SUBSIDY")){
                    a2 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("APPOINTMENT_NOT_ON_TIME")){
                    a3 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("SERVE_TIME_NOT_COMMUNICATE")){
                    a4 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("VISIT_IN_TIME")){
                    a5 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("EARLY_OR_LATE_IN_TWELVE_HOURS")){
                    a6 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("EARLY_OR_DELAY_SIGN")){
                    a7 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("NOT_WEAR_UNIFORM")){
                    a8 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("SIGN_NOT_BY_SELF")){
                    a9 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("ASSIST_INSTALL_APP")){
                    a10 = rewardPunishment.getAmount();
                }else if(rewardPunishment.getCode().contains("SERIOUS_COMPLAINT")){
                    a11 = rewardPunishment.getAmount();
                }
        }

            BigDecimal totalExtraCharge = BigDecimal.ZERO;
            List<OrderExtraChargeItemApply> extraChargeApply = orderArtisanInfo.getExtraChargeApply();
            for (OrderExtraChargeItemApply apply : extraChargeApply) {
                if(apply.getApplyStatusId() == 3){
                    totalExtraCharge = totalExtraCharge.add(apply.getApplyTotalPrice());
                }
            }

            //set data
            data.add(orderArtisanInfo.getOrderId());
            data.add(artisanType);
            data.add(categoryServingName);
            data.add(earlyCompleteOrder ? "是" : "否");
            data.add(productNumber.toString());
            data.add(order.getMerchantTotalPaymentAmount() == null ? "0":order.getMerchantTotalPaymentAmount().toString());
            data.add(order.getArtisanIncomeAmount() == null ? "0":order.getArtisanIncomeAmount().toString());
            data.add(order.getArtisanAdditionAmount() == null ? "0":order.getArtisanAdditionAmount().toString());
            data.add(totalExtraCharge.toString());
            data.add(order.getArtisanDistancePaymentAmount() == null ? "0":order.getArtisanDistancePaymentAmount().toString());
            data.add(order.getArtisanServiceAmount() == null ? "0":order.getArtisanServiceAmount().toString());
            data.add(order.getArtisanPraiseAwardAmount() == null ? "0":order.getArtisanPraiseAwardAmount().toString());
            data.add(order.getArtisanRecommendAwardAmount() == null ? "0":order.getArtisanRecommendAwardAmount().toString());

            data.add(a1.toString());
            data.add(a2.toString());
            data.add(a3.toString());
            data.add(a4.toString());
            data.add(a5.toString());
            data.add(a6.toString());
            data.add(a7.toString());
            data.add(a8.toString());
            data.add(a9.toString());
            data.add(a10.toString());
            data.add(a11.toString());
            data.add(order.getMerchantName());
            data.add(productName);

            datas.add(data);
        }
//        String fileName = "/Users/dandan/Documents/import_files/九月份师傅收入详情.xlsx";
        String fileName = "/Users/dandan/Documents/import_files/三月份师傅收入详情.xlsx";
        ExportFileUtils.writeExcel(datas,fileName, OrderArtisanIncomeAmountModel.class);
    }

    @Test
    public void diffDataBaseSelect(){
        List<OrderPartsInfo> result = orderSelectMapper.selectOrderArtisanLeaderInfo();
        if(result != null && result.size() > 0){
            for (OrderPartsInfo orderPartsInfo : result) {
                System.out.println(orderPartsInfo);
            }
        }

    }

    @Test
    public void selectArtisanSpecialInfo(){
        //获取所有的星标师傅


    }

    @Test
    public void insertOrUpdateForTrim(){
        orderSelectMapper.insertOrUpdateDataForTrim();
    }

}
