package com.dandan.mapper;

import com.dandan.mapper.resultset.ProblemOrderResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2021/5/10
 */
@Mapper
public interface ProblemSelectMapper {

    List<ProblemOrderResult> selectOrderByTime(@Param("startTime") String startTime, @Param("endTime") String endTime);

    String selectCurrentProblemByOrderId(@Param("orderId") String orderId);

    String selectHistoryProblemByOrderId(@Param("orderId") String orderId);

}
