package com.dandan.common.model.filter;

import lombok.*;
import org.springframework.stereotype.Component;

/**
 * Created by dandan On 八月 24 2019
 */
@Setter
@Getter
@NoArgsConstructor
@Component
public class PagingData {
    public static final int MAX_PAGE_SIZE = 2000;
    private int pageNumber;//数量-页
    private int pageSize;//页数

    public PagingData(int pageNumber, int pageSize) {

        if(pageSize < 1){
            pageSize = 1;
        }

        if(pageSize > MAX_PAGE_SIZE){
            pageSize = MAX_PAGE_SIZE;
        }

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public int getStartRecordNumber(){
        int startRecordNumber = (this.pageNumber - 1) * this.pageSize;
        return startRecordNumber;
    }

    public int getFormIndex(){
        return (this.pageNumber - 1) * this.pageSize;
    }

    public int getToIndex(){
        return this.pageNumber * this.pageSize;
    }

    public int getToIndex(int maxIndex){
        int toIndex = this.pageNumber * this.pageSize;
        toIndex = toIndex > maxIndex ? maxIndex : toIndex;
        return toIndex;
    }

}
