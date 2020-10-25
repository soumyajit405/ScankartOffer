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
public class ItemWithBarcodeDto  {

	private int id;

	private String name;
	
	private String price;
	
	private String offerName;
	
	private int offerId;
	
	private String imageName;
	
}