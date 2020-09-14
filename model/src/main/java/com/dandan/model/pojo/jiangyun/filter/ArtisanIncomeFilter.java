package com.dandan.model.pojo.jiangyun.filter;

import com.dandan.common.model.pojo.TimeRange;
import lombok.Data;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class ArtisanIncomeFilter {

    private Integer statusId;
    private TimeRange completedTime;
    private String categoryServingName;
    private String orderId;


}
