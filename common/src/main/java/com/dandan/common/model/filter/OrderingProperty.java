package com.dandan.common.model.filter;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by dandan On 八月 24 2019
 */
@Setter
@Getter
public class OrderingProperty {

    private int priority;//优先级
    private String property;//排序字段
    private boolean asc;//是否升序



}
