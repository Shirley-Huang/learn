package com.dandan.work.handler.api.acceptance;

import lombok.Data;

import java.util.List;

/**
 * Created by dandan On 十月 10 2019
 */
@Data
public class OrderAcceptanceItems {

    private List<AcceptanceItems> acceptanceItems;
    private String description;
    private String content;
    private Integer displayOrder;

}
