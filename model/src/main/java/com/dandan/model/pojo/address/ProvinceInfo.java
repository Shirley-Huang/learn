package com.dandan.model.pojo.address;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2021/6/9
 */
@Data
public class ProvinceInfo implements Serializable {

    @JSONField(name = "citycode")
    private String cityCode;
    @JSONField(name = "adcode")
    private String adCode;
    private String name;
    private String level;
    private List<ProvinceInfo> districts;

}
