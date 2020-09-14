package com.dandan.model.test;

import com.dandan.common.model.pojo.TimeRange;

import java.text.ParseException;

/**
 * Created by dandan On 九月 10 2019
 */
public class DateTest {

    public static void main(String[] args) throws ParseException {
        String timeInterval = "2019-09-16/2019-09-30";
        String startTime = timeInterval.substring(0,timeInterval.indexOf("/"));
        String endTime = timeInterval.substring(timeInterval.indexOf("/") + 1,timeInterval.length());
        System.out.println(startTime);
        System.out.println(endTime);

        TimeRange timeRange = TimeRange.toTimeRange(startTime,endTime);
        System.out.println(timeRange.getFrom() + "--" + timeRange.getTo());



    }

}
