package com.techconative.financeTracker.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="income")
public class Income {
	@Id
	@GeneratedValue(strategy 
            = GenerationType.AUTO) 
	@Column(name = "income_id") 
	private Integer incomeId;
	public Integer getIncomeId() {
		return incomeId;
	}
	public void setIncomeId(Integer incomeId) {
		this.incomeId = incomeId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getAmountCredited() {
		return amountCredited;
	}
	public void setAmountCredited(Double amountCredited) {
		this.amountCredited = amountCredited;
	}
	public LocalDate getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDate dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	@Column(name = "description") 
	private String description;
	@Column(name = "amount") 
	private Double amountCredited;
	@Column(name = "received_date") 
	private LocalDate dateOfTransaction;

}
