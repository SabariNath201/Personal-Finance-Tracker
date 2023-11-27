package com.techconative.financeTracker.service;

import com.techconative.financeTracker.exception.FinanceException;
import com.techconative.financeTracker.exception.NotFoundException;
import com.techconative.financeTracker.model.ExpenseDTO;

public interface ExpenseService {

	public ExpenseDTO updateExpense(Integer expenseId, ExpenseDTO expenseDTO) throws NotFoundException, FinanceException;
	public ExpenseDTO createExpense(ExpenseDTO expenseDTO);
	public void deleteExpense(Integer expenseId) throws NotFoundException;
	public ExpenseDTO getExpense(Integer expenseId) throws NotFoundException;
	
}
