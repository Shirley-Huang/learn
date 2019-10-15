package com.dandan.mapper;

import com.dandan.common.utils.files.ExportFileUtils;
import com.dandan.model.pojo.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dandan On 十月 12 2019
 */
public class OrderMapperTest extends AbstractPersistenceTest {


    @Autowired
    private OrderMapper orderMapper;

    @Test
    public void selectOrder(){
        List<Order> orders = orderMapper.selectOrderLimit();

        List<List<String>> datas = new ArrayList<>();
        for (Order order : orders) {
            List<String> data = new ArrayList<>();
            data.add(order.getOrderId());
            data.add(order.getPartnerOrderNum());
            data.add(order.getStatusId().toString());
            data.add(order.getMerchantId());
            data.add(order.getMerchantName());
            data.add(order.getArtisanName());
            data.add(order.getArtisanMobile());
            datas.add(data);
        }
        ExportFileUtils.writeExcel(datas);
    }

}
