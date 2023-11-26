package com.techconative.financeTracker.exception;

public class FinanceException extends Exception{
	
	private String errorCode;
	private String errorMessage;
	private String[] parameter;
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public FinanceException(String errorCode, String errorMessage, String...parameter) {
		
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.parameter = parameter;
	}

	public String[] getParameter() {
		return parameter;
	}

}
