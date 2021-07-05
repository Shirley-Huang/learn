package com.dandan.mapper;

import com.dandan.mapper.resultset.ProblemOrderResult;
import com.dandan.model.pojo.address.Province;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2021/5/10
 */
@Mapper
public interface ArtisanSelectMapper {

    //根据手机号查询师傅id
    String getArtisanIdByMobile(@Param("mobile") String mobile);

    //根据师傅id查询师傅月结账单
    String getMonthlyBillByArtisanIdAndMonth(@Param("artisanId") String artisanId, @Param("month") String monthName);

    //修改师傅月结账单金额
    void modifyMonthlyBillById(@Param("billId")String billId, @Param("amount")BigDecimal amount);

    //删除月结账单奖惩项
    void deleteMonthlyReward(@Param("billId")String billId);
    List<String> getMonthlyReward(@Param("billId")String billId);

    List<Province> selectProvinces();


}
