package com.scankart.app.feature.offer;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.HashMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.scankart.app.dto.RestResponse;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
public interface OfferService 
{
    
    @RequestMapping(value ="getOffers/{userId}/{limitCount}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public RestResponse getOffers( @PathVariable("userId") int userId, @RequestHeader(value="api-key") String apiKey,@PathVariable("limitCount") int limitCount);
    
    @RequestMapping(value ="getOffers/{userId}/{merchantId}/{limitCount}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public RestResponse getOffers( @PathVariable("userId") int userId, @RequestHeader(value="api-key") String apiKey,@PathVariable("limitCount") int limitCount,@PathVariable("merchantId") int merchantId);
    
    @RequestMapping(value ="generateOffer/{userId}/{merchantId}" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public RestResponse generateOffer( @PathVariable("userId") int userId,@PathVariable("merchantId") int merchantId);
    
    @RequestMapping(value ="health" , method =  RequestMethod.GET , headers =  "Accept=application/json" )
    public RestResponse healthCheck();
        
}
