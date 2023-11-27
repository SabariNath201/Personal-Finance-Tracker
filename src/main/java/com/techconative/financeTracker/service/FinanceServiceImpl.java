package com.techconative.financeTracker.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.techconative.financeTracker.exception.NotFoundException;
import com.techconative.financeTracker.mapper.FinanceMapper;
import com.techconative.financeTracker.model.BookDTO;
import com.techconative.financeTracker.model.Budget;
import com.techconative.financeTracker.model.BudgetDTO;
import com.techconative.financeTracker.model.Expense;
import com.techconative.financeTracker.model.FinanceDTO;
import com.techconative.financeTracker.model.FinanceReportDTO;
import com.techconative.financeTracker.model.FinanceReportDTO.PL;
import com.techconative.financeTracker.model.Income;
import com.techconative.financeTracker.model.IncomeDTO;
import com.techconative.financeTracker.repository.BudgetRepository;
import com.techconative.financeTracker.repository.ExpenseRepository;
import com.techconative.financeTracker.repository.IncomeRepository;
import com.techconative.financeTracker.utils.Constants;
import com.techconative.financeTracker.utils.StatusCodes;

@Service
public class FinanceServiceImpl implements FinanceService{
	@Autowired
	private IncomeRepository incomeRepository;
	@Autowired
	private ExpenseRepository expenseRepository;
	@Autowired
	private BudgetRepository budgetRepository;
	
	private final FinanceMapper FINANCE_MAPPER_IMPL = Mappers.getMapper( FinanceMapper.class );
	
	@Override
	public IncomeDTO addIncome(IncomeDTO incomedto) {
		Income income = FINANCE_MAPPER_IMPL.mapIncomeDTOtoIncome(incomedto);
		incomeRepository.save(income);
		return FINANCE_MAPPER_IMPL.mapIncometoIncomeDTO(income);
	}
	
	@Override
	public FinanceReportDTO getFinancialReports() {
		
		FinanceReportDTO financeReportDTO = new FinanceReportDTO();
		List<FinanceDTO> financeDTO = new ArrayList<FinanceDTO>();
		Double expense = 0.0;
		Double income = 0.0;
		List<Income> incomeDetails = incomeRepository.findAll();
		income = incomeDetails.stream().collect(Collectors.summingDouble(Income::getAmountCredited));
		List<Expense> expenseDetails = expenseRepository.findAll();
		expense = expenseDetails.stream().collect(Collectors.summingDouble(Expense::getAmountDebited));
		if(!CollectionUtils.isEmpty(incomeDetails)) {
			financeDTO.addAll(FINANCE_MAPPER_IMPL.mapIncometoFinanceDTO(incomeDetails));
		}
		if(!CollectionUtils.isEmpty(expenseDetails)) {
			financeDTO.addAll(FINANCE_MAPPER_IMPL.mapExpensetoFinanceDTO(expenseDetails));
		}
	
		if(!CollectionUtils.isEmpty(financeDTO)) {
			financeDTO.sort((f1, f2)
	                  -> f1.getDateOfTransaction().compareTo(
	                      f2.getDateOfTransaction()));
		}
		financeReportDTO.setFinanceList(financeDTO);
		financeReportDTO.setTotalExpense(expense);
		financeReportDTO.setTotalIncome(income);
		Double totalProfitOrLoss = income - expense;
		financeReportDTO.setTotalProfitOrLoss(totalProfitOrLoss);
		if(totalProfitOrLoss>0) {
			financeReportDTO.setProfit_Loss(PL.Profit);
		}else {
			financeReportDTO.setProfit_Loss(PL.Loss);
		}
		
		return financeReportDTO;	
	}
	
	@Override
	public BudgetDTO addBudget(BudgetDTO budgetDTO) {
		Budget budget = FINANCE_MAPPER_IMPL.mapBudgetDTOtoBudget(budgetDTO);
		budgetRepository.save(budget);
		return FINANCE_MAPPER_IMPL.mapBudgetToBudgetDTO(budget);
	}
	
	@Override
	public BudgetDTO getBudget(Integer budgetID) throws NotFoundException{
		if(! budgetRepository.existsById(budgetID)) {
			throw new NotFoundException(StatusCodes.BUDGET_NOT_FOUND.getCode(), StatusCodes.BUDGET_NOT_FOUND.getDescription(), budgetID.toString());
		}
		return FINANCE_MAPPER_IMPL.mapBudgetToBudgetDTO(budgetRepository.findById(budgetID).get());
	}
	
	@Override
	public BookDTO getBooks(String bookFilter) {
		
		BookDTO bookDTO = new BookDTO();
		List<String> bookFilters =Arrays.asList(bookFilter.split(","));
		if(bookFilters.contains(Constants.EXPENSE_BOOK)) {
			List<Expense> expenseDetails = expenseRepository.findAll();
			if(!CollectionUtils.isEmpty(expenseDetails)) {
				bookDTO.setExpenseBook(expenseDetails);
			}
		}
		
		if(bookFilters.contains(Constants.INCOME_BOOK)) {
			List<Income> incomeDetails = incomeRepository.findAll();
			if(!CollectionUtils.isEmpty(incomeDetails)) {
				bookDTO.setIncomeBook(incomeDetails);
			}
		}

		if(bookFilters.contains(Constants.BUDGET_BOOK)) {
			List<Budget> budgetDetails = budgetRepository.findAll();
			if(!CollectionUtils.isEmpty(budgetDetails)) {
				bookDTO.setBudgetBook(budgetDetails);
			}
		}
		
		return bookDTO;
	}
}
