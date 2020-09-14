package com.dandan.model.pojo.jiangyun.filter;

import com.dandan.common.model.pojo.TimeRange;
import lombok.Data;

/**
 * @Description
 * @Author dandan
 * @Date 2019-10-24
 */
@Data
public class TakeOrderTimeFilter {

    private String oscStatusCode;
    private TimeRange oscCreateTime;
    private String orecExcludeEmployeeId;
    private String orecStatusCode;

}
