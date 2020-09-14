package com.dandan.common.utils.test;

import com.dandan.common.utils.DateTimeUtility;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

/**
 * @Description
 * @Author dandan
 * @Date 2020/5/28
 */
public class DateUtility {

    public void getDateInterval() throws ParseException {
        Date beginDate = DateTimeUtility.parseYYYYMMDD("2020-01-01");
        Date endDate = DateTimeUtility.parseYYYYMMDD("2020-01-08");
        List<String> interval = new ArrayList<>();
        Calendar startTime = Calendar.getInstance();
        startTime.setTime(beginDate);

        Calendar endTime = Calendar.getInstance();
        endTime.setTime(endDate);

        while (endTime.after(startTime)){
            interval.add(DateTimeUtility.formatYYYYMMDD(startTime));
            startTime.add(Calendar.DAY_OF_MONTH,1);
        }
        System.out.println(interval);
    }

    public void test(){
        int a = 0;
        int b = 2;
        System.out.println(a / b);

        BigDecimal a1 = BigDecimal.ZERO;
        BigDecimal b1 = new BigDecimal(2);
        System.out.println(a1.divide(b1));
    }

    public void test02(){
        String a = null;
        if(a.contains("abc")){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

}
