package com.dandan.postman.jiangyun.request;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderRequest {
	private String customerName;
	private String customerPhoneNumber;
	private String userExpectDate;
	private Integer userExpectTimeSoltId;
	//private BigDecimal customerPrepayAmount;
	private String provinceId;
	private String provinceName;
	private String cityId;
	private String cityName;
	private String districtId;
	private String districtName;
	private String address;
	private String houseNumber;
	private BigDecimal customerAddressLongitude;
	private BigDecimal customerAddressLatitude;
	private String serviceProviderId;
	private String serviceProviderName;
	private ProductRequest orderProduct;



}
