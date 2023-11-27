package com.techconative.financeTracker.model;

public class FinanceDTO extends CommonDTO{
	
	private Integer incomeId;
	private Integer expenseId;
	private Double amountCredited;
	private Double amountDebited;
	
	public Integer getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expenseId) {
		this.expenseId = expenseId;
	}
	
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


}
