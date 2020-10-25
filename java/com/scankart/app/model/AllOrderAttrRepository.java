package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllOrderAttrRepository extends JpaRepository<AllOrderAttr, Long>
{
 
	@Query("select a from AllOrderAttr a where a.allOrder.id=?1 and a.orderAttributeTypePl.name=?2")
	AllOrderAttr getOrderAttrByName(int orderId,String name);
	
	@Query("select a from OrderAttributeTypePl a where name=?1")
	OrderAttributeTypePl getOrderAttrByName(String name);
	
	@Query("select count(a.id) from AllOrderAttr a")
	int getCountOfOrderAttr();
	
	@Modifying
	@Query("update AllOrderAttr a set a.value =?3 where a.allOrder.id=?1 and a.id=?2 ")
	void updateOrderAttr(int orderId, int orderAttrType, String value);
}