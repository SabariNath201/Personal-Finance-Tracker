package com.techconative.financeTracker.model;

import java.util.List;

public class FinanceReportDTO {
	public enum PL{
		Profit, Loss;
	}
	private List<FinanceDTO> financeList;
	public List<FinanceDTO> getFinanceList() {
		return financeList;
	}
	public void setFinanceList(List<FinanceDTO> financeList) {
		this.financeList = financeList;
	}
	public Double getTotalIncome() {
		return totalIncome;
	}
	public void setTotalIncome(Double totalIncome) {
		this.totalIncome = totalIncome;
	}
	public Double getTotalExpense() {
		return totalExpense;
	}
	public void setTotalExpense(Double totalExpense) {
		this.totalExpense = totalExpense;
	}
	public Double getTotalProfitOrLoss() {
		return totalProfitOrLoss;
	}
	public void setTotalProfitOrLoss(Double totalProfitOrLoss) {
		this.totalProfitOrLoss = totalProfitOrLoss;
	}
	public PL getProfit_Loss() {
		return Profit_Loss;
	}
	public void setProfit_Loss(PL profit_Loss) {
		Profit_Loss = profit_Loss;
	}
	private Double totalIncome;
	private Double totalExpense;
	private Double totalProfitOrLoss;
	private PL Profit_Loss;

}
