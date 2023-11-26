package com.techconative.financeTracker.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="expense")
public class Expense {
	//expense_Id, date_of_payment, paid_to, description, amount
	@Id
	@GeneratedValue(strategy 
            = GenerationType.AUTO) 
	@Column(name = "expense_Id") 
	private Integer expenseId;
	@Column(name = "date_of_payment") 
	private LocalDate dateOfTransaction;
	@Column(name = "paid_to") 
	private String paidTo;

	@Column(name = "description") 
	private String description;
	@Column(name = "amount") 
	private Double amountDebited;
	
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
	public Integer getExpenseId() {
		return expenseId;
	}
	public void setExpenseId(Integer expId) {
		this.expenseId = expId;
	}
	
	
}
