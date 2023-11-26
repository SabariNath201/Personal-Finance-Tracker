package com.techconative.financeTracker.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="budget")
public class Budget {
	
	@Id
	@GeneratedValue(strategy 
            = GenerationType.AUTO) 
	@Column(name = "budget_Id") 
	private Integer budgetId;
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
	@Column(name = "income")
	private Double income;
	@Column(name = "rent_Expense")
	private Double rentExpense;
	@Column(name = "food_Expense")
	private Double foodExpense;
	@Column(name = "insurance_Expense")
	private Double insuranceExpense;
	@Column(name = "savings")
	private Double savings;

}
