package com.techconative.financeTracker.utils;

public enum StatusCodes {
	
	EXPENSE_NOT_FOUND("E4040", "Expense details not found for given Expense Id : {0}"),
	BUDGET_NOT_FOUND("E4041", "Budget details not found for given budget Id : {0}"),
	INVALID_DATE("E400", "Date of Transaction is invalid : {0}");
	
	private String code;
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private StatusCodes(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
}
