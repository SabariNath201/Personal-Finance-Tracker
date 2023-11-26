package com.techconative.financeTracker.model;

import java.time.LocalDate;

public class ExpenseDTO {
	
	private Integer expenseId;
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public String getPaidTo() {
		return paidTo;
	}
	public void setPaidTo(String paidTo) {
		this.paidTo = paidTo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmountDebited() {
		return amountDebited;
	}
	public void setAmountDebited(Double amountDebited) {
		this.amountDebited = amountDebited;
	}
	private LocalDate dateOfTransaction;
	private String paidTo;
	private String description;
	private Double amountDebited;

}
