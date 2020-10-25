package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllUserRepository extends JpaRepository<AllUser, Long>
{
	@Query("select a from AllUser a where a.phone=?1")
	AllUser findUserByPhone(String phoneNumber);
	
	
	@Query("select COALESCE(max(id),0) from AllUser ")
	int findUserCount();
	
	@Query("select a from AllUser a where a.id=?1")
	AllUser getUserById(int userId);
	
	@Query("select a from AllMerchant a where a.id=?1")
	AllMerchant getMerchantById(int merchantId);
	
 
}