package com.techconative.financeTracker.model;

public class BudgetDTO {
	
	private Integer budgetId;
	private Double income;
	private Double rentExpense;
	private Double foodExpense;
	private Double insuranceExpense;
	private Double savings;

	
	public Integer getBudgetId() {
		return budgetId;
	}
	public void setBudgetId(Integer budgetId) {
		this.budgetId = budgetId;
	}
	public Double getIncome() {
		return income;
	}
	public void setIncome(Double income) {
		this.income = income;
	}
	public Double getRentExpense() {
		return rentExpense;
	}
	public void setRentExpense(Double rentExpense) {
		this.rentExpense = rentExpense;
	}
	public Double getFoodExpense() {
		return foodExpense;
	}
	public void setFoodExpense(Double foodExpense) {
		this.foodExpense = foodExpense;
	}
	public Double getInsuranceExpense() {
		return insuranceExpense;
	}
	public void setInsuranceExpense(Double insuranceExpense) {
		this.insuranceExpense = insuranceExpense;
	}
	public Double getSavings() {
		return savings;
	}
	public void setSavings(Double savings) {
		this.savings = savings;
	}

}
