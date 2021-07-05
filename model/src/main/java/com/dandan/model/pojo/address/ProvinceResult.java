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
public class ProvinceResult implements Serializable {

    private String count;
    @JSONField(name = "districts")
    private List<ProvinceInfo> provinces;

}
