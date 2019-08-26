package com.dandan.common.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by dandan On 八月 25 2019
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeRange {

    private Date from;
    private Date to;

    /**
     * @Description: 创建时间段对象
     * @param beginDate	开始日期，系统只解析日期
     * @param endDate 结束日期，系统只解析日期，且会增加1天
     * @return
     * @throws ParseException
     */
    public static TimeRange toTimeRange(String beginDate, String endDate) throws ParseException {
        if(!StringUtils.isEmpty(beginDate) && !StringUtils.isEmpty(endDate)){
            TimeRange range = new TimeRange();
            range.setFrom(DateTimeUtility.parseYYYYMMDD(beginDate));
            range.setTo(new Date(DateTimeUtility.parseYYYYMMDD(endDate).getTime() + TimeUnit.DAYS.toMillis(1)));
            return range;
        }
        return null;
    }

}
