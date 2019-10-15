package com.dandan.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dandan On 八月 26 2019
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum SexType {

    F("F","女"),
    M("M","男");

    private String code;
    private String description;

    private static Map<String, SexType> typeOfCodes;



    static {
        typeOfCodes = new HashMap<String, SexType>();
        for (SexType value : SexType.values()) {
            typeOfCodes.put(value.getCode(),value);
        }
    }

    public static SexType getSexByCode(String code){
        return typeOfCodes.get(code);
    }



}
