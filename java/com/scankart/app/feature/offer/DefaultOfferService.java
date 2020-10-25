package com.scankart.app.feature.offer;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scankart.app.dto.RestResponse;


@Service("DefaultOfferService")
public class DefaultOfferService implements OfferService{

	@Autowired
	OfferComponent offerComponent;

	@Override
	public RestResponse getOffers(int userId, String apiKey, int limitCount) {
		// TODO Auto-generated method stub
		return offerComponent.getOffers(userId, apiKey,limitCount);
	}
	
	@Override
	public RestResponse generateOffer(int userId, int merchantId) {
		// TODO Auto-generated method stub
		return offerComponent.generateOffer(userId, merchantId);
	}
	
	
	@Override
	public RestResponse getOffers(int userId, String apiKey, int limitCount, int merchantId) {
		// TODO Auto-generated method stub
		return offerComponent.getOffers(userId, apiKey,limitCount, merchantId);
	}
	
	@Override
	public RestResponse healthCheck() {
		// TODO Auto-generated method stub
		RestResponse response = new RestResponse();
		response.setResponse("Up and Running");
		return response;
	}
	
}
