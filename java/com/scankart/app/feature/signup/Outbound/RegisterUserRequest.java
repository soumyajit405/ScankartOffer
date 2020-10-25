package com.scankart.app.feature.signup.Outbound;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RegisterUserRequest {
	
	private String phoneNumber;
	
	private String otp;
	
	private int userRole;

}
