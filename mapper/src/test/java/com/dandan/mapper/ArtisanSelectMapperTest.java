package com.dandan.mapper;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.fastjson.JSONObject;
import com.dandan.common.utils.HttpClientUtils02;
import com.dandan.common.utils.files.ExportFileUtils;
import com.dandan.common.utils.files.ImportFileUtils;
import com.dandan.mapper.resultset.ProblemOrderResult;
import com.dandan.model.pojo.address.Province;
import com.dandan.model.pojo.address.ProvinceInfo;
import com.dandan.model.pojo.address.ProvinceResult;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by dandan On 十月 12 2019
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ArtisanSelectMapperTest {


    @Autowired
    private ArtisanSelectMapper artisanSelectMapper;


    @Test
    public void modifyMonthlyBill() {


        List<String> sql = new ArrayList<>();
        String monthlyName = "2021年5月份月结账单";
        String date = "2021-06-01 02:00:00";

        String fileName = "/Users/dandan/Documents/import_files/artisan_bill_modify.xlsx";
        List<List<String>> results = ImportFileUtils.readExcel(fileName);
        System.out.println();
        for (List<String> result : results) {
            System.out.println(result.toString());
            String artisanMobile = result.get(0);
            BigDecimal amount = new BigDecimal(result.get(1));
            amount = amount.setScale(2, BigDecimal.ROUND_HALF_UP);
            String artisanName = result.get(2);
            System.out.println(artisanMobile + artisanName + amount);
            String artisanId = artisanSelectMapper.getArtisanIdByMobile(artisanMobile);
            String monthlyBillId = artisanSelectMapper.getMonthlyBillByArtisanIdAndMonth(artisanId, monthlyName);
            if(monthlyBillId == null || monthlyBillId.equals("")){
                String error = "师傅月结账单不存在,artisanId="+artisanId+"，师傅手机号="+artisanMobile;
                String insertSql = "INSERT INTO jiangyun_cbs.t_artisan_monthly_bill(name,artisan_leader_id,artisan_leader_name,total_balance,receivable_balance,create_time)"
                        + "VALUES (\'"+monthlyName+"\',\'" + artisanId+ "\',\'" +artisanName + "\',"  +amount + "," +amount + ",\'"  + date+  "\');";
                sql.add(error);
                sql.add(insertSql);
                continue;
            }
            //生成脚本
//            String deleteReward = "delete from jiangyun_cbs.t_artisan_monthly_bill_reward where monthly_bill_id =" + monthlyBillId + ";";
            String deleteReward = "update jiangyun_cbs.t_artisan_monthly_bill_reward set reward_amount = 0 where monthly_bill_id = " + monthlyBillId + ";";
            String modifyBillSql =
                  "update jiangyun_cbs.t_artisan_monthly_bill set receivable_balance = " + amount +
                          ",total_balance = " + amount +
                          " where id ="  + monthlyBillId + ";";

            sql.add(deleteReward);
            sql.add(modifyBillSql);
        }

        System.out.println("开始");
        for (String s : sql) {
            System.out.println(s);
        }
        System.out.println("结束");

    }

    @Test
    public void districtData() throws Exception{

        List<Province> provinces = artisanSelectMapper.selectProvinces();

        Map<String, Object> params = new HashMap<>();
        params.put("key","3d68c889e84b5b6a461d1b2673d25b7f");
        params.put("subdistrict","2");

//        String response = "{\"status\":\"1\",\"info\":\"OK\",\"infocode\":\"10000\",\"count\":\"1\",\"suggestion\":{\"keywords\":[],\"cities\":[]},\"districts\":[{\"citycode\":\"010\",\"adcode\":\"110000\",\"name\":\"北京市\",\"center\":\"116.405285,39.904989\",\"level\":\"province\",\"districts\":[{\"citycode\":\"010\",\"adcode\":\"110100\",\"name\":\"北京城区\",\"center\":\"116.405285,39.904989\",\"level\":\"city\",\"districts\":[{\"citycode\":\"010\",\"adcode\":\"110116\",\"name\":\"怀柔区\",\"center\":\"116.637122,40.324272\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110119\",\"name\":\"延庆区\",\"center\":\"115.985006,40.465325\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110113\",\"name\":\"顺义区\",\"center\":\"116.653525,40.128936\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110109\",\"name\":\"门头沟区\",\"center\":\"116.105381,39.937183\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110117\",\"name\":\"平谷区\",\"center\":\"117.112335,40.144783\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110105\",\"name\":\"朝阳区\",\"center\":\"116.486409,39.921489\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110101\",\"name\":\"东城区\",\"center\":\"116.418757,39.917544\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110107\",\"name\":\"石景山区\",\"center\":\"116.195445,39.914601\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110115\",\"name\":\"大兴区\",\"center\":\"116.338033,39.728908\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110112\",\"name\":\"通州区\",\"center\":\"116.658603,39.902486\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110118\",\"name\":\"密云区\",\"center\":\"116.843352,40.377362\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110114\",\"name\":\"昌平区\",\"center\":\"116.235906,40.218085\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110111\",\"name\":\"房山区\",\"center\":\"116.139157,39.735535\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110106\",\"name\":\"丰台区\",\"center\":\"116.286968,39.863642\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110102\",\"name\":\"西城区\",\"center\":\"116.366794,39.915309\",\"level\":\"district\",\"districts\":[]},{\"citycode\":\"010\",\"adcode\":\"110108\",\"name\":\"海淀区\",\"center\":\"116.310316,39.956074\",\"level\":\"district\",\"districts\":[]}]}]}]}";

        List<String> provinceSql = new ArrayList<>();
        List<String> citySql = new ArrayList<>();
        List<String> districtSql = new ArrayList<>();
        for (Province province : provinces) {

            params.put("keywords",province.getName());
            String response = HttpClientUtils02.requestString("https://restapi.amap.com/v3/config/district?"
                , null, params, "GET");
            ProvinceResult result = JSONObject.parseObject(response, ProvinceResult.class);
            System.out.println(result);

            if(Integer.valueOf(result.getCount()) == 1){
                System.out.println(result.getProvinces().toString());
            }
            ProvinceInfo provinceInfo = result.getProvinces().get(0);
            //生成省sql
            if(provinceInfo.getLevel().equals("province")){
                String provinceId = provinceInfo.getAdCode();
                provinceSql.add("INSERT INTO jiangyun_cbs.t_province2 (id, name) VALUES (\'"+ provinceId +"\', \'"+provinceInfo.getName()+"\');");

                List<ProvinceInfo> cityCodes = provinceInfo.getDistricts();
                for (ProvinceInfo cityCode : cityCodes) {
                    if(cityCode.getLevel().equals("city")){
                        String cityId = cityCode.getAdCode();
                        citySql.add("INSERT INTO jiangyun_cbs.t_city2 (id, name, city_code, province_id) VALUES (\'"
                                + cityId +"\', \'"+cityCode.getName()+"\', \'"+cityCode.getCityCode()+"\', \'"+provinceId+"\');");


                        List<ProvinceInfo> districts = cityCode.getDistricts();
                        for (ProvinceInfo district : districts) {
                            if(district.getLevel().equals("district")){
                                districtSql.add("INSERT INTO jiangyun_cbs.t_district2 (id, name, city_id) VALUES (\'"
                                        +district.getAdCode()+"\', \'"+district.getName()+"\', \'"+cityId+"\');");
                            }
                        }

                    }


                }

            }


        }


        for (String s : provinceSql) {
            System.out.println(s);
        }
        for (String s : citySql) {
            System.out.println(s);
        }
        for (String s : districtSql) {
            System.out.println(s);
        }




    }

    @Test
    public void provinceData(){
        //1、读取两个表
        //2、根据市code作为key，value为List区
        //3、遍历两个集合，打印出不同数据的sql语句
        String fileName1 = "/Users/dandan/Documents/import_files/amap.xlsx";
        List<List<String>> gaoDeDistricts = ImportFileUtils.readExcel(fileName1);
        //3、遍历两个集合，打印出不同数据的sql语句
        String fileName2 = "/Users/dandan/Documents/import_files/jy_districts2.xlsx";
        List<List<String>> jyDistricts = ImportFileUtils.readExcel(fileName2);

        Map<String,List<List<String>>> gaoDeMap = new HashMap<>();
        for (List<String> gaoDeDistrict : gaoDeDistricts) {
            if(gaoDeDistrict.size() < 3){
                continue;
            }
            String cityCode = gaoDeDistrict.get(2);
            if(StringUtils.isBlank(cityCode)){
                continue;
            }
            List<List<String>> lists = gaoDeMap.get(cityCode);
            if(lists == null){
                lists = new ArrayList<>();
            }
            lists.add(gaoDeDistrict);
            gaoDeMap.put(cityCode,lists);
        }

        Map<String,List<List<String>>> jyMap = new HashMap<>();
        for (List<String> gaoDeDistrict : jyDistricts) {
            String cityCode = gaoDeDistrict.get(2);
            if(StringUtils.isBlank(cityCode)){
                continue;
            }
            List<List<String>> lists = jyMap.get(cityCode);
            if(lists == null){
                lists = new ArrayList<>();
            }
            lists.add(gaoDeDistrict);
            jyMap.put(cityCode,lists);
        }

        boolean flag = false;
        List<String> districtIds = new ArrayList<>();
        for (String key : gaoDeMap.keySet()) {
            List<List<String>> gaoDeCityDistricts = gaoDeMap.get(key);
            List<List<String>> jyCityDistricts = jyMap.get(key);

            if(jyCityDistricts == null){
                continue;
            }

            for (List<String> gaoDeCityDistrict : gaoDeCityDistricts) {
                flag = false;

                String cityId = null;
                for (List<String> jyCityDistrict : jyCityDistricts) {
                    cityId = jyCityDistrict.get(3);

                    if(gaoDeCityDistrict.get(1).equals(jyCityDistrict.get(0))){
                        flag = true;
                        break;
                    }

                }

                if(!flag){
                    //打印
                    districtIds.add(gaoDeCityDistrict.get(1));
//                    System.out.println("我没有----"+gaoDeCityDistrict.toString());
                    //INSERT INTO jiangyun_cbs.t_district (id, name, city_id) VALUES ('610703', '南郑区', '610703');
                    System.out.println("INSERT INTO jiangyun_cbs.t_district (id, name, city_id) VALUES (\'"
                            +gaoDeCityDistrict.get(1)+"\',\' "+gaoDeCityDistrict.get(0)+"\',\'"+ cityId+"\');");
                }



            }

        }

        System.out.println(districtIds);
        System.out.println(districtIds.size());

    }


}
