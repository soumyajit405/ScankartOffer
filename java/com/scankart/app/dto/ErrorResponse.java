package com.scankart.app.dto;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ErrorResponse {
	
	private String message;
	private int errorCode;
	
	public ErrorResponse(String message, int errorCode) {
		this.errorCode = errorCode;
		this.message = message;
	}

}
