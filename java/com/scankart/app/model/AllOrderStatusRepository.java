package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllOrderStatusRepository extends JpaRepository<AllInstoreOrderStatus, Long>
{
 	@Query("select a from OrderStatusPl a where a.name =?1")
	OrderStatusPl getOrderStatusPl(String name);
 	
 	@Modifying
 	@Query("update AllInstoreOrderStatus a set a.orderStatusPl.id=?1 where a.allOrder.id=?2")
	void updateOrderStatus(int statusId, int orderId);
}