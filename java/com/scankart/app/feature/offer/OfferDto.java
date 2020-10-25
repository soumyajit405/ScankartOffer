package com.scankart.app.feature.offer;


import java.io.Serializable;
import javax.persistence.*;

import com.scankart.app.model.AllMerchantAttribute;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
public class OfferDto  {

	private int id;

	private String name;
	
	private String offerOwner;
	
	private int maxTimes;
	
	private int maxDiscount;
	
	private Timestamp startDate;
	
	private Timestamp endDate;
	
	private String merchantName;
	
	private String summary;
	
	private int discountPercentage;
	
}