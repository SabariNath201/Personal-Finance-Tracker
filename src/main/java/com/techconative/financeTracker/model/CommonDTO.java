package com.techconative.financeTracker.model;

import java.time.LocalDate;

public class CommonDTO {
	
	private String description;
	private LocalDate dateOfTransaction;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

}
