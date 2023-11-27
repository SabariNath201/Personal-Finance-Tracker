package com.techconative.financeTracker.model;

public class IncomeDTO extends CommonDTO{
	
	private Integer incomeId;
	private Double amountCredited;
	
	public Integer getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}
	
	public Double getAmountCredited() {
		return amountCredited;
	}
	public void setAmountCredited(Double amountCredited) {
		this.amountCredited = amountCredited;
	}
}
