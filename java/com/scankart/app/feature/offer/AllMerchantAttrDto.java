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
public class AllMerchantAttrDto  {

	private int id;

	private String name;
	
	private String value;
	
}