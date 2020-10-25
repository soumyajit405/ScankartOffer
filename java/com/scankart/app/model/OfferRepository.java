package com.scankart.app.model;

import org.springframework.data.jpa.repository.Modifying;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long>
{
 
	@Query(value = "select b.* from user_offers a,offers b where a.offer_id = b.id and a.user_id=?1  limit ?2,?3", nativeQuery = true)
	List<Offer> getOffers(int userId,int startCount, int endCount);
	
	
	@Query("select count(a.id) from UserOffer a where a.allUser.id=?1 and a.status='ACT'")
	int getOfferCount(int userId);
	
	@Query(value = "select a.* from  offers a, merchant_offers b , user_offers c where  b.offer_id = c.offer_id " + 
			"and a.id = b.offer_id and a.id = c.offer_id " + 
			"and b.merchant_id = ?4 and c.user_id =?1 and c.status ='ACT' " + 
			"union " + 
			"select b.* from user_offers c , offers b where b.id =c.offer_id " + 
			"and c.user_id =?1 and c.status ='ACT' and b.business_type_id is null" +  
			"  limit ?2,?3", nativeQuery = true)
	List<Offer> getOffers(int userId,int startCount, int endCount, int merchantId);
	
	
	@Query(value="select count(c.id) from  merchant_offers b , user_offers c where  b.offer_id = c.offer_id " + 
			"and b.merchant_id = ?2 and c.user_id =?1 and c.status ='ACT' ",nativeQuery = true)
	int getOfferCount(int userId, int merchantId);
	
	@Query(value ="select count(c.id) from user_offers c , offers b where b.id =c.offer_id " + 
			"and c.user_id =?1 and c.status ='ACT' and b.business_type_id is null",nativeQuery = true)
	int getCompanyOfferCount(int userId);
	
	@Query("select a from MerchantOffer a where a.offer.id=?1 ")
	MerchantOffer getMerchantOffer(int offerId);
	
	@Query("select a from UserOffer a where a.allUser.id=?1 ")
	List<UserOffer> getAllUserOffers(int offerId);
	
	@Query("select a from Offer a, UserOffer b where  a.businessTypePl.id <>?1 and a.businessTypePl.id is not NULL and a.id <> b.offer.id")
	List<Offer> getAllOffers(int businessTypeId);
	
}