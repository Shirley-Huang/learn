package com.dandan.postman.jiangyun;

import com.dandan.postman.jiangyun.request.CreateOrderRequest;
import com.dandan.postman.jiangyun.request.ProductRequest;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by dandan On 九月 14 2019
 */
public class MerchantOrderService {

    /**
     * 创建工单
     * @throws Exception
     */
    @Test
    public void createOrder() throws Exception{


        //1、设置工单基本参数
        setCreateOrderParams();


    }

    private void setCreateOrderParams() {
        CreateOrderRequest orderBaseInfo = new CreateOrderRequest();
        orderBaseInfo.setCustomerName("黄丹丹");
        orderBaseInfo.setCustomerPhoneNumber("17600903965");
        orderBaseInfo.setUserExpectDate("2019-10-01");
        orderBaseInfo.setUserExpectTimeSoltId(4);

        orderBaseInfo.setProvinceId("11000");
        orderBaseInfo.setProvinceName("北京市");
        orderBaseInfo.setCityId("110100");
        orderBaseInfo.setCityName("北京市");
        orderBaseInfo.setDistrictId("110114");
        orderBaseInfo.setDistrictName("昌平区");
        orderBaseInfo.setAddress("昌平区回龙观街道金宝贝西二旗龙域中心(昌发展万科广场店)");
        orderBaseInfo.setCustomerAddressLatitude(new BigDecimal(40.067076));
        orderBaseInfo.setCustomerAddressLongitude(new BigDecimal(116.316972));
        orderBaseInfo.setHouseNumber("2503");

        orderBaseInfo.setServiceProviderId("1");
        orderBaseInfo.setServiceProviderName("匠云");

        ProductRequest orderProduct = new ProductRequest();
        orderProduct.setName("【匠云】家用室外锁(M2)");
        orderProduct.setMainPicUrl("http://file.jiangyunshouhou.com/product/2018/10/27/17599.jpg?x-oss-process=image/crop,h_768,w_768,x_78,y_0");
        orderProduct.setNumber(1);
        orderProduct.setProductId("106450");
        orderProduct.setSecondCategoryId(2);
        orderProduct.setSecondCategoryName("家用室外锁");


    }

}
