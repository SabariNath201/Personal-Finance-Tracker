package com.techconative.financeTracker.model;

import java.util.List;

public class BookDTO {
	
	private List<Budget> budgetBook;
	private List<Income> incomeBook;
	private List<Expense> expenseBook;
	public List<Budget> getBudgetBook() {
		return budgetBook;
	}
	public void setBudgetBook(List<Budget> budgetBook) {
		this.budgetBook = budgetBook;
	}
	public List<Income> getIncomeBook() {
		return incomeBook;
	}
	public void setIncomeBook(List<Income> incomeBook) {
		this.incomeBook = incomeBook;
	}
	public List<Expense> getExpenseBook() {
		return expenseBook;
	}
	public void setExpenseBook(List<Expense> expenseBook) {
		this.expenseBook = expenseBook;
	}
	
	
}
