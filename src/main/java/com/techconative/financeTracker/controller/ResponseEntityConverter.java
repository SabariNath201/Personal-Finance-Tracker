package com.techconative.financeTracker.controller;

import org.springframework.http.ResponseEntity;

import com.google.gson.Gson;

public class ResponseEntityConverter {
	
	private ResponseEntityConverter() {
		
	}
	
	@SuppressWarnings("unchecked")
	public static <R> ResponseEntity<R> ok (R response){
		
		if(String.class.isAssignableFrom(response.getClass())) {
			Gson gson = new Gson();
			return ResponseEntity.ok((R) gson.toJson(response));
		}
		
		return ResponseEntity.ok(response);
	}

}
