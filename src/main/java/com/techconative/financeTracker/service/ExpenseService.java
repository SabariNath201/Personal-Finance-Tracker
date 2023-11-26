/**
 * 
 */
package com.techconative.financeTracker.service;

import java.time.LocalDate;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techconative.financeTracker.exception.FinanceException;
import com.techconative.financeTracker.exception.NotFoundException;
import com.techconative.financeTracker.mapper.FinanceMapper;
import com.techconative.financeTracker.model.Expense;
import com.techconative.financeTracker.model.ExpenseDTO;
import com.techconative.financeTracker.repository.ExpenseRepository;
import com.techconative.financeTracker.utils.StatusCodes;

/**
 * This is Service Layer where business logics and communication between presentation tier and persistence tier take place
 *
 */
@Service
public class ExpenseService {
	
	@Autowired
	private ExpenseRepository expenseRepository;
	
	private final FinanceMapper FINANCE_MAPPER_IMPL = Mappers.getMapper( FinanceMapper.class );
	
	/**
	 * @param expId
	 * @param expense
	 * @return updated Expense information from Database
	 * @throws NotFoundException
	 * @throws FinanceException
	 */
	public ExpenseDTO updateExpense(Integer expenseId, ExpenseDTO expenseDTO) throws NotFoundException, FinanceException{
		
		validatingExpenseID(expenseId);
		if(expenseDTO.getDateOfTransaction().isAfter(LocalDate.now())) {
			throw new FinanceException(StatusCodes.INVALID_DATE.getCode(), StatusCodes.INVALID_DATE.getDescription(), expenseDTO.getDateOfTransaction().toString());
		}
		Expense expense = FINANCE_MAPPER_IMPL.mapExpenseDTOtoExpense(expenseDTO);
		expense.setExpenseId(expenseId);
		expenseRepository.save(expense);
		return getExpense(expenseId);
	}

	/**
	 * validatingExpenseID method used for verification of expense Id existence in finance database
	 * 
	 * @param expId
	 * @throws FinanceException
	 */
	private void validatingExpenseID(Integer expenseId) throws NotFoundException {
		if(! expenseRepository.existsById(expenseId)) {
			throw new NotFoundException(StatusCodes.EXPENSE_NOT_FOUND.getCode(), StatusCodes.EXPENSE_NOT_FOUND.getDescription(), expenseId.toString());
		}
	}
	
	/**
	 * @param expense
	 * @return expense details along with generated expense ID
	 */
	public ExpenseDTO createExpense(ExpenseDTO expenseDTO) {
		Expense expense = FINANCE_MAPPER_IMPL.mapExpenseDTOtoExpense(expenseDTO);
		expenseRepository.save(expense);
		return FINANCE_MAPPER_IMPL.mapExpenseToExpenseDTO(expense);
	}

	public void deleteExpense(Integer expenseId) throws NotFoundException {
		validatingExpenseID(expenseId);
		 expenseRepository.deleteById(expenseId);
	}
	
	public ExpenseDTO getExpense(Integer expenseId) throws NotFoundException {
		validatingExpenseID(expenseId);
		return FINANCE_MAPPER_IMPL.mapExpenseToExpenseDTO(expenseRepository.findById(expenseId).get());
	}
}
