package com.techconative.financeTracker.model;

import java.time.LocalDate;

public class FinanceDTO {
	
	private Integer incomeId;
	private Integer expenseId;
	private LocalDate dateOfTransaction;
	private String description;
	private Double amountCredited;
	private Double amountDebited;
	
	public Double getAmountCredited() {
		return amountCredited;
	}

	public void setAmountCredited(Double amountCredited) {
		this.amountCredited = amountCredited;
	}

	public Double getAmountDebited() {
		return amountDebited;
	}

	public void setAmountDebited(Double amountDebited) {
		this.amountDebited = amountDebited;
	}
	
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}

	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}

	public Integer getIncomeId() {
		return incomeId;
	}

	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
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

	public Integer getExpenseId() {
		
		return expenseId;
	}

}
