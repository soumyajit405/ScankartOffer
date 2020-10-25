package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AllUserLoginRepository extends JpaRepository<AllUserLogin, Long>
{
	@Query("select a from LoginType a where a.type=?1")
	LoginType getLoginType(String type);
	
	@Query("select a from AllUserLogin a where a.loginType.id=?1 and a.userId=?2 and a.token=?3")
	AllUserLogin checkUserValidity(int type, int userId, String token);
	
 
}