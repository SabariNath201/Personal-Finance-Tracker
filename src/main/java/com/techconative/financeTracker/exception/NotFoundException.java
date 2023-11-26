package com.techconative.financeTracker.exception;

public class NotFoundException extends Exception{
	
	private String errorCode;
	private String errorMessage;
	private String[] parameter;
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public NotFoundException(String errorCode, String errorMessage, String...parameter) {
		System.out.println("1--" + errorCode+" -- 2 -- "+ errorMessage + " -- 3 -- "+ parameter);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.parameter = parameter;
	}

	public String[] getParameter() {
		return parameter;
	}
}
