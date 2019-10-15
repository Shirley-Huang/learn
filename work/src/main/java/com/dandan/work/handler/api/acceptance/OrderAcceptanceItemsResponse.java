package com.dandan.work.handler.api.acceptance;

import com.dandan.work.handler.api.ServiceResponse;
import lombok.Data;

import java.util.List;

/**
 * Created by dandan On 十月 10 2019
 */
@Data
public class OrderAcceptanceItemsResponse extends ServiceResponse {

    private List<OrderAcceptanceItems> orderAcceptanceItems;

}
