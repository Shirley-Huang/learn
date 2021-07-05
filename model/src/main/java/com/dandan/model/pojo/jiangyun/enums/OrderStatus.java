package com.dandan.model.pojo.jiangyun.enums;

import com.dandan.common.model.i18n.EnumMessageTranslator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author dandan
 * @Date 2020/11/20
 */
public enum  OrderStatus {

    WAITING_CONFIRM(1, "WAITING_CONFIRM", "待确认"),
    WAITING_GRAB(2, "WAITING_GRAB", "待派单"),
    //WAITING_EXAM(3, "WAITING_EXAM", "待考试"),
    ASSIGN_TO_BE_CONFIRMED(4, "ASSIGN_TO_BE_CONFIRMED", "派单待确认"),
    WAITING_ARTISAN_PAY(5, "WAITING_ARTISAN_PAY", "待师傅支付"),
    WAITING_DELIVERY(6, "WAITING_DELIVERY", "待发货"),
    WAITING_RECEIVE(7, "WAITING_RECEIVE", "待收货"),
    WAITING_COMMUNICATE(8, "WAITING_COMMUNICATE", "待沟通"),
    WAITING_SERVE(9, "WAITING_SERVE", "待上门"),
    WAITING_ENV_CHECK(10, "WAITING_ENV_CHECK", "待环境检查"),
    WAITING_CONSTRUCT(11, "WAITING_CONSTRUCT", "待施工"),
    WAITING_CUSTOMER_ACCEPT(12, "WAITING_CUSTOMER_ACCEPT", "待客户验收"),
    WAITING_CUSTOMER_PAY(13, "WAITING_CUSTOMER_PAY", "待客户支付"),
    SERVING_QUALITY_ASSURANCE(14, "SERVING_QUALITY_ASSURANCE", "工单质保中"),
    WAITING_REPAIR(15, "WAITING_REPAIR", "待返修"),
    WAITING_REPAIR_ACCEPT(16, "WAITING_REPAIR_ACCEPT", "待返修验收"),
    WAITING_RISK_MANAGEMENT(17, "WAITING_RISK_MANAGEMENT", "待风控"),
    WAITING_RETURN_GOODS(18, "WAITING_RETURN_GOODS", "待退货"),
    WAITING_RETURN_GOODS_CONFIRM(19, "WAITING_RETURN_GOODS_CONFIRM", "待退货确认"),
    COMPLETED(20, "COMPLETED", "已完成"),
    CANCELED(21, "CANCELED", "已取消"),
    WAITING_ARTISAN_ADDRESS_CONFIRM(22, "WAITING_ARTISAN_ADDRESS_CONFIRM", "待师傅确认收货地址"),
    WAITING_CONTACT_CUSTOMER(23,"WAITING_CONTACT_CUSTOMER","待联系客户");

    private Integer id;
    private String code;
    private String description;

    private static Map<String, OrderStatus> codeToOrderStatus;
    private static Map<Integer, OrderStatus> idToOrderStatus;

    static {
        codeToOrderStatus = new HashMap<String, OrderStatus>();
        idToOrderStatus = new HashMap<Integer, OrderStatus>();
        for (OrderStatus orderStatus : OrderStatus.values()) {
            codeToOrderStatus.put(orderStatus.getCode(), orderStatus);
            idToOrderStatus.put(orderStatus.getId(), orderStatus);

        }
    }

    public static final OrderStatus fromCode(String code) {
        return codeToOrderStatus.get(code);
    }
    public static final OrderStatus fromId(Integer id) {
        return idToOrderStatus.get(id);
    }

    private OrderStatus(Integer id, String code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return EnumMessageTranslator.getName(getClass().getSimpleName() + "." + code);
    }


}
