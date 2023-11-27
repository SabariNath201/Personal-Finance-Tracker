package com.techconative.financeTracker.service;

import com.techconative.financeTracker.exception.NotFoundException;
import com.techconative.financeTracker.model.BookDTO;
import com.techconative.financeTracker.model.BudgetDTO;
import com.techconative.financeTracker.model.FinanceReportDTO;
import com.techconative.financeTracker.model.IncomeDTO;

public interface FinanceService {
	
	public IncomeDTO addIncome(IncomeDTO incomedto);
	public FinanceReportDTO getFinancialReports();
	public BudgetDTO addBudget(BudgetDTO budgetDTO);
	public BudgetDTO getBudget(Integer budgetID) throws NotFoundException;
	public BookDTO getBooks(String bookFilter);
}
