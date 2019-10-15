package com.dandan.common.model.filter;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by dandan On 八月 24 2019
 */
@Setter
@Getter
@Service
public class SearchFilter {

    private static final int MAX_RECORD = 5000;

    private Integer limit;

    private boolean paged;
    private PagingData pagingData;

    private boolean ordered;
    private List<OrderingProperty> orderingProperties;

    public Integer getLimit() {
        if(limit == null){
            return MAX_RECORD;
        }
        return limit;
    }

}
