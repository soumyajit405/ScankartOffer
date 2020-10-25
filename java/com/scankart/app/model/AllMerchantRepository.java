package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllMerchantRepository extends JpaRepository<AllMerchant, Long>
{
 
	@Query(value = "select * from all_merchant  where business_type=?1 limit ?2,?3", nativeQuery = true)
	List<AllMerchant> getAllMerchantsByType(int businessType,int startCount, int endCount);
	
	@Query(value  = "select * from all_merchant  limit ?1,?2", nativeQuery = true)
	List<AllMerchant> getAllMerchants(int startCount, int endCount);
	
	@Query("select count(a.id) from AllMerchant a where a.businessTypePl.name=?1")
	int getAllMerchantsByTypeCount(String businessType);
	
	@Query("select count(a.id) from AllMerchant a")
	int getAllMerchantCount();
	
	@Query("select a from AllMerchant a where a.id=?1")
	AllMerchant getMerchantById(int merchantId);
	
	@Query("select a from BusinessTypePl a where a.name=?1")
	BusinessTypePl getBusinessType(String type);
	
}