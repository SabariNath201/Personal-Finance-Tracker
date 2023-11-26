package com.techconative.financeTracker.model;

import java.text.MessageFormat;

import org.apache.commons.lang3.StringUtils;

public class ErrorMessageFormatter {
	private ErrorMessageFormatter() {
		
	}

	
	public static String formatErrorMessage(String errorMessage, String... parameters ) {
		
		if(StringUtils.isBlank(errorMessage)){
			errorMessage = "Internal Server Error";
		}else {
			errorMessage = MessageFormat.format(errorMessage, parameters);
		}
		return errorMessage;
	}
}
