package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllMerchantAttributeRepository extends JpaRepository<AllMerchantAttribute, Long>
{
 
	@Query("select a from AllMerchantAttribute a where a.allMerchant.id=?1")
	List<AllMerchantAttribute> getMerchantAttributeById(int merchantId);
	
	@Query("select a from AllMerchantAttribute a where a.value=?2 and a.businessAttrTypePl.id = ?1 and a.allMerchant.id=?3")
	AllMerchantAttribute getInventiryByCode(int attrId,String barcode, int merchantId);
	
}