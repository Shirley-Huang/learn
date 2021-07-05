package com.dandan.test;

import com.dandan.common.model.pojo.TimeRange;
import com.dandan.common.utils.DateTimeUtility;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;

import java.util.*;
import java.util.regex.Pattern;

/**
 * @Description
 * @Author dandan
 * @Date 2020/10/19
 */
public class RandomTest {

    private static final Random random = new Random();

    @Test
    public void test(){
        Calendar appointTime = Calendar.getInstance();
        appointTime.add(Calendar.DATE, new Random().nextInt(5) + 1);//加1～5天
        appointTime.set(Calendar.HOUR_OF_DAY,new Random().nextInt(24));
        System.out.println(appointTime.getTime());
    }
    @Test
    public void test02(){
        String productName = "【美的】智能门锁LK-BF202K(202)";
        List<String> brandNames = new ArrayList<String>();
        Pattern pattern = Pattern.compile("(?<=【)(.+?)(?=】)");
        java.util.regex.Matcher matcher = pattern.matcher(productName);
        while (matcher.find()) {
            brandNames.add(matcher.group());
        }
        String brandName = brandNames.get(0);
        System.out.println(brandName);
    }

    @Test
    public void test03(){
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("f",0);
        map.put("b",0);
        map.put("k",0);
        map.put("d",0);

        System.out.println(map.toString());
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        System.out.println(list.toString());
        Map<String,Integer> newMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            newMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(newMap.toString());


    }

    @Test
    public void test04(){
        Calendar createTimeTo = Calendar.getInstance();
        System.out.println(createTimeTo.getTime());
        createTimeTo.add(Calendar.HOUR_OF_DAY,-2);
        System.out.println(createTimeTo.getTime());
    }

    @Test
    public void test05(){
        String s1 = "N100";
        String[] strs = new String[]{"S1","S2","P100","P200","N100"};
        System.out.println(String.join("|",strs));
        if(s1.contains(String.join("|",strs))){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
        System.out.println(StringUtils.join(strs,"|"));
    }
    @Test
    public void test06(){
        List<String> t1 = new ArrayList<>();
        t1.addAll(Arrays.asList("a","b","c","d"));
        List<String> t2 = new ArrayList<>();
        for (String s : t1) {
            if(s.equals("b") || s.equals("c")){
                t2.add(s);
            }
        }
        List<String> t3 = Arrays.asList("ss","dd");
        t1.removeAll(t2);
        System.out.println(t1);
        t1.addAll(t3);
        System.out.println(t1);
    }

    @Test
    public void test07(){
        //2020-12-06 15:45:1
        Date time = new Date(2020 - 1900,12 - 1,6,17,35,45);
        Calendar createTimeFrom = Calendar.getInstance();
        createTimeFrom.setTime(time);
        createTimeFrom.add(Calendar.HOUR_OF_DAY,-1);
        createTimeFrom.add(Calendar.MINUTE,-56);
        createTimeFrom.set(Calendar.SECOND,0);



        Calendar createTimeTo = Calendar.getInstance();
        createTimeTo.setTime(time);
        createTimeTo.add(Calendar.HOUR_OF_DAY,-1);
        createTimeTo.add(Calendar.MINUTE,-50);
        createTimeTo.set(Calendar.SECOND,0);



        TimeRange createTime = new TimeRange(createTimeFrom.getTime(), createTimeTo.getTime());
        System.out.println(DateTimeUtility.formatYYYYMMDDHHMMSS(createTime.getFrom()));
        System.out.println(DateTimeUtility.formatYYYYMMDDHHMMSS(createTime.getTo()));
    }

    @Test
    public void test08(){
        String str = "101,190";
        if(str.contains("10")){
            System.out.println(true);
        }
    }

}
