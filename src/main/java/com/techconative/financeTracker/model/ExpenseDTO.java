package com.techconative.financeTracker.model;

import java.time.LocalDate;

public class ExpenseDTO {
	
	private Integer expenseId;
	private LocalDate dateOfTransaction;
	private String paidTo;
	private String description;
	private Double amountDebited;
	
	public Double getAmountDebited() {
		return amountDebited;
	}

	public void setAmountDebited(Double amountDebited) {
		this.amountDebited = amountDebited;
	}

	public String getPaidTo() {
		return paidTo;
	}

	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}
	
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	
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

	public Integer getExpenseId() {
		
		return expenseId;
	}

}
