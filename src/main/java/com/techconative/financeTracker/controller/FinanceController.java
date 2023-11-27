package com.techconative.financeTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techconative.financeTracker.exception.FinanceException;
import com.techconative.financeTracker.exception.NotFoundException;
import com.techconative.financeTracker.model.BookDTO;
import com.techconative.financeTracker.model.BudgetDTO;
import com.techconative.financeTracker.model.ExpenseDTO;
import com.techconative.financeTracker.model.FinanceReportDTO;
import com.techconative.financeTracker.model.IncomeDTO;
import com.techconative.financeTracker.service.ExpenseServiceImpl;
import com.techconative.financeTracker.service.FinanceServiceImpl;

@RestController
@RequestMapping(value = "/api")
public class FinanceController {
	@Autowired
	private ExpenseServiceImpl expenseService;
	
	@Autowired
	private FinanceServiceImpl financeService;
	
	@PostMapping(value ="/incomes")
	public ResponseEntity<IncomeDTO> addIncome(@RequestBody IncomeDTO incomedto){
		return new ResponseEntity<IncomeDTO>(financeService.addIncome(incomedto),  HttpStatus.CREATED);
	}
	
	@PostMapping(value = "/expenses")
	public ResponseEntity<ExpenseDTO> postExpense(@RequestBody ExpenseDTO expense){ 
		return new ResponseEntity<ExpenseDTO>(expenseService.createExpense(expense),  HttpStatus.CREATED);	
	}
	
	@PutMapping(value ="/expenses/{expID}")
	public ResponseEntity<ExpenseDTO> putExpense(@PathVariable Integer expID, @RequestBody ExpenseDTO expense) throws FinanceException,NotFoundException{
		return ResponseEntityConverter.ok(expenseService.updateExpense(expID, expense));
	}
	
	@GetMapping(value ="/expenses/{expID}")
	public ResponseEntity<ExpenseDTO> getExpense(@PathVariable Integer expID) throws FinanceException,NotFoundException{
		return ResponseEntityConverter.ok(expenseService.getExpense(expID));
	}
	
	@DeleteMapping(value ="/expenses/{expID}")
	public <T> ResponseEntity<T> deleteExpense(@PathVariable Integer expID) throws FinanceException,NotFoundException{
		expenseService.deleteExpense(expID);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@GetMapping(value ="/reports")
	public ResponseEntity<FinanceReportDTO> getFinancialReports() throws FinanceException,NotFoundException{
		return ResponseEntityConverter.ok(financeService.getFinancialReports());
	}
	
	@PostMapping(value ="/budgets")
	public ResponseEntity<BudgetDTO> addBudget(@RequestBody BudgetDTO budgetDTO){
		return new ResponseEntity<BudgetDTO>(financeService.addBudget(budgetDTO),  HttpStatus.CREATED);
	}

	@GetMapping(value ="/budgets/{budgetId}")
	public ResponseEntity<BudgetDTO> getBudget(@PathVariable Integer budgetId) throws NotFoundException{
		return ResponseEntityConverter.ok(financeService.getBudget(budgetId));
	}
	
	@GetMapping(value = "/books")
	public ResponseEntity<BookDTO> getBooks(@RequestParam String bookFilter) throws NotFoundException{ 
		return ResponseEntityConverter.ok(financeService.getBooks(bookFilter));
	}
}
