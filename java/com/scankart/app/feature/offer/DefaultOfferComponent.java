package com.scankart.app.feature.offer;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.scankart.app.AppStartupRunner;
import com.scankart.app.dto.ErrorResponse;
import com.scankart.app.dto.RestResponse;
import com.scankart.app.model.AllInventoryAttr;
import com.scankart.app.model.AllInventoryAttrRepository;
import com.scankart.app.model.AllMerchant;
import com.scankart.app.model.AllMerchantAttribute;
import com.scankart.app.model.AllMerchantAttributeRepository;
import com.scankart.app.model.AllMerchantRepository;
import com.scankart.app.model.AllOrder;
import com.scankart.app.model.AllOrderRepository;
import com.scankart.app.model.AllUserRepository;
import com.scankart.app.model.BusinessTypePl;
import com.scankart.app.model.MerchantOffer;
import com.scankart.app.model.Offer;
import com.scankart.app.model.OfferRepository;
import com.scankart.app.model.UserOffer;
import com.scankart.app.model.UserOfferRepository;
import com.scankart.app.util.CustomMessages;
import com.scankart.app.util.DistanceChecker;
import com.scankart.app.util.ValidatorUtility;


@Transactional
@Repository
@Service("DefaultOfferComponent")
public class DefaultOfferComponent implements OfferComponent{


	@Autowired 
	OfferRepository offerRepo;
	
	@Autowired
	ValidatorUtility validatorUtil ;
	
	@Autowired
	AllMerchantRepository allMerchantRepo;
	
	@Autowired
	AllUserRepository userRepo ;
	
	@Autowired
	UserOfferRepository userOfferRepo ;
	
	@Override
	public RestResponse getOffers(int userId, String apiKey, int limitCount) {
		RestResponse response = new RestResponse();
		String records = AppStartupRunner.configValues.get("Records");
		int totalCount =0;
		Class userOfferClass =null;
        try {
        userOfferClass = Class.forName("com.scankart.app.model.UserOffer");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		try {
			int validationStatus = validatorUtil.validateUser(apiKey,userId,1);
			if (validationStatus == 0 || validationStatus == -1) {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("UAU"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
				return response;
			}
			List<OfferDto> OffersDto= new ArrayList<>();
				totalCount = offerRepo.getOfferCount(userId);
				List<Offer> offers= offerRepo.getOffers(userId,limitCount,Integer.parseInt(records));
				//List<Object[]> objects= offerRepo.getOffers(userId,limitCount,limitCount+Integer.parseInt(records));
			for (Offer offer: offers) {
			//UserOffer userOffer = (UserOffer) userOfferClass.cast(object);
			OfferDto offerDto = new OfferDto();
			offerDto.setEndDate(offer.getEndDate());
			offerDto.setId(offer.getId());
			offerDto.setMaxDiscount(offer.getMaxDiscount());
			offerDto.setDiscountPercentage(offer.getDiscountPercent());
			// offerDto.setMaxTimes((int)object[5]);
			if ((offer.getOfferOwner()).equalsIgnoreCase("Merchant")) {
				offerDto.setMerchantName(offer.getMerchantOffers().get(0).getAllMerchant().getName());
				offerDto.setOfferOwner("Merchant");
			} else {
				offerDto.setOfferOwner("Scankart");
			}
			offerDto.setName(offer.getOfferName());
			offerDto.setStartDate(offer.getStartDate());
			offerDto.setSummary("Use "+offerDto.getName() +" to get "+offerDto.getDiscountPercentage()+"% OFF upto ₹"+offerDto.getMaxDiscount());
			OffersDto.add(offerDto);
			}
			HashMap<String, Object> validationMessage = new HashMap<String, Object>();
			validationMessage.put("message", CustomMessages.getCustomMessages("FS"));
			validationMessage.put("key", 200);
			validationMessage.put("data", OffersDto);
			validationMessage.put("totalCount", totalCount);
			validationMessage.put("limit", limitCount+Integer.parseInt(records));
			response.setResponse(validationMessage);
					
			} catch( Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;
	}
	
	@Override
	public RestResponse getOffers(int userId, String apiKey, int limitCount, int merchantId) {
		RestResponse response = new RestResponse();
		String records = AppStartupRunner.configValues.get("Records");
		int totalCount =0;
         
		try {
			int validationStatus = validatorUtil.validateUser(apiKey,userId,1);
			if (validationStatus == 0 || validationStatus == -1) {
				HashMap<String, Object> validationMessage = new HashMap<String, Object>();
				validationMessage.put("message", CustomMessages.getCustomMessages("UAU"));
				validationMessage.put("key", 200);
				response.setResponse(validationMessage);
				return response;
			}
			List<OfferDto> OffersDto= new ArrayList<>();
				totalCount = offerRepo.getOfferCount(userId,merchantId);
				totalCount = totalCount + offerRepo.getCompanyOfferCount(userId);
				List<Offer> offers= offerRepo.getOffers(userId,limitCount,Integer.parseInt(records),merchantId);
				//List<Object[]> objects= offerRepo.getOffers(userId,limitCount,limitCount+Integer.parseInt(records));
			for (Offer offer: offers) {
			//UserOffer userOffer = (UserOffer) userOfferClass.cast(object);
			OfferDto offerDto = new OfferDto();
			offerDto.setEndDate(offer.getEndDate());
			offerDto.setId(offer.getId());
			offerDto.setMaxDiscount(offer.getMaxDiscount());
			offerDto.setDiscountPercentage(offer.getDiscountPercent());
			// offerDto.setMaxTimes((int)object[5]);
			if ((offer.getOfferOwner()).equalsIgnoreCase("Merchant")) {
				offerDto.setMerchantName(offer.getMerchantOffers().get(0).getAllMerchant().getName());
				offerDto.setOfferOwner("Merchant");
			} else {
				offerDto.setOfferOwner("Scankart");
			}
			offerDto.setName(offer.getOfferName());
			offerDto.setStartDate(offer.getStartDate());
			offerDto.setSummary("Use "+offerDto.getName() +" to get "+offerDto.getDiscountPercentage()+"% OFF upto ₹"+offerDto.getMaxDiscount());
			OffersDto.add(offerDto);
			}
			HashMap<String, Object> validationMessage = new HashMap<String, Object>();
			validationMessage.put("message", CustomMessages.getCustomMessages("FS"));
			validationMessage.put("key", 200);
			validationMessage.put("data", OffersDto);
			validationMessage.put("totalCount", totalCount);
			validationMessage.put("limit", limitCount+Integer.parseInt(records));
			response.setResponse(validationMessage);
					
			} catch( Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;
	}
	
	@Override
	public RestResponse generateOffer(int userId, int merchantId) {
		RestResponse response = new RestResponse();
         
		try {
		
			AllMerchant allMerchant=allMerchantRepo.getMerchantById(merchantId);
			int businessTypePl = allMerchant.getBusinessTypePl().getId();
			
			List<OfferDto> OffersDto= new ArrayList<>();
			List<Offer> offers= offerRepo.getAllOffers(businessTypePl);
			for (Offer offer: offers) {
			//UserOffer userOffer = (UserOffer) userOfferClass.cast(object);
			OfferDto offerDto = new OfferDto();
			offerDto.setEndDate(offer.getEndDate());
			offerDto.setId(offer.getId());
			offerDto.setMaxDiscount(offer.getMaxDiscount());
			offerDto.setDiscountPercentage(offer.getDiscountPercent());
			// offerDto.setMaxTimes((int)object[5]);
			if ((offer.getOfferOwner()).equalsIgnoreCase("Merchant")) {
				offerDto.setMerchantName(offer.getMerchantOffers().get(0).getAllMerchant().getName());
				offerDto.setOfferOwner("Merchant");
			} else {
				offerDto.setOfferOwner("Scankart");
			}
			offerDto.setName(offer.getOfferName());
			offerDto.setStartDate(offer.getStartDate());
			offerDto.setSummary("Use "+offerDto.getName() +" to get "+offerDto.getDiscountPercentage()+"% OFF upto ₹"+offerDto.getMaxDiscount());
			OffersDto.add(offerDto);
			UserOffer userOffer = new UserOffer();
			userOffer.setAllUser(userRepo.getUserById(userId));
			userOffer.setOffer(offer);
			userOffer.setOfferDate(new Timestamp(System.currentTimeMillis()));
			userOffer.setStatus("ACT");
			userOfferRepo.save(userOffer);
			break;
			}
			
			HashMap<String, Object> validationMessage = new HashMap<String, Object>();
			validationMessage.put("message", CustomMessages.getCustomMessages("FS"));
			validationMessage.put("key", 200);
			if (OffersDto.size() > 0) {
			validationMessage.put("data", OffersDto.get(0));
			}
			else {
				validationMessage.put("data","NA");
			}
			response.setResponse(validationMessage);
					
			} catch( Exception e) {
			e.printStackTrace();
			ErrorResponse errorResponse = new ErrorResponse(CustomMessages.getCustomMessages("ISE"), 500);
			response.setResponse(errorResponse);
		}
		return response;
	}
}
