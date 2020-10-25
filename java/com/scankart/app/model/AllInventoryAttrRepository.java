package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllInventoryAttrRepository extends JpaRepository<AllInventoryAttr, Long>
{
 	
	@Query("select a from AllInventoryAttr a where a.value=?2 and a.allInventoryAttrPl.name = ?1 and a.allInventory.allMerchant.id=?3")
	AllInventoryAttr getInventoryByCode(String attrName,String barcode, int merchantId);
	
	@Query("select a from AllInventoryAttr a where  a.allInventory.allMerchant.id=?1 and a.allInventory.id=?2")
	List<AllInventoryAttr> getInventoryByCode(int merchantId, int inventoryId);
	
}