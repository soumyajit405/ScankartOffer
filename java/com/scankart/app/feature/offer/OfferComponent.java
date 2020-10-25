package com.scankart.app.feature.offer;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import com.scankart.app.dto.RestResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

public interface OfferComponent 
{
    
    public RestResponse getOffers(int userId, String apiKey, int limitCount);
    
    public RestResponse generateOffer(int userId, int merchantId);
    
    public RestResponse getOffers(int userId, String apiKey, int limitCount, int merchantId);
    
        
}
