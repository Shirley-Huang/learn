package com.dandan.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by dandan On 八月 27 2019
 */
@Mapper
public interface OrderLogisticeMapper {

    List<String> selectOrderIds();

}
