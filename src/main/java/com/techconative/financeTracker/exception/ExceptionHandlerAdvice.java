package com.techconative.financeTracker.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.techconative.financeTracker.model.ApplicationExceptionModel;
import com.techconative.financeTracker.model.ErrorMessageFormatter;

@ControllerAdvice
public class ExceptionHandlerAdvice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	@ExceptionHandler(FinanceException.class)
	public final ApplicationExceptionModel handleFinanceException (FinanceException financeException, WebRequest request) {
		ApplicationExceptionModel applicationExceptionModel = new ApplicationExceptionModel();
		applicationExceptionModel.setErrorCode(financeException.getErrorCode());
		applicationExceptionModel.setErrorMessage(ErrorMessageFormatter.formatErrorMessage(financeException.getErrorMessage(), financeException.getParameter()));
		return applicationExceptionModel;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ResponseBody
	@ExceptionHandler(NotFoundException.class)
	public final ApplicationExceptionModel handleNotFoundException (NotFoundException notFoundException, WebRequest request) {
		ApplicationExceptionModel applicationExceptionModel = new ApplicationExceptionModel();
		applicationExceptionModel.setErrorCode(notFoundException.getErrorCode());
		applicationExceptionModel.setErrorMessage(ErrorMessageFormatter.formatErrorMessage(notFoundException.getErrorMessage(), notFoundException.getParameter()));
		return applicationExceptionModel;
	}
	
	@ResponseStatus
	@ResponseBody
	@ExceptionHandler(Exception.class)
	public final ApplicationExceptionModel handleException (Exception exception, WebRequest request) {
		ApplicationExceptionModel applicationExceptionModel = new ApplicationExceptionModel();
		applicationExceptionModel.setErrorCode("5000");
		applicationExceptionModel.setErrorMessage("Internal Server Error");
		return applicationExceptionModel;
	}

}
