package com.techconative.financeTracker.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.techconative.financeTracker.model.Budget;
import com.techconative.financeTracker.model.BudgetDTO;
import com.techconative.financeTracker.model.Expense;
import com.techconative.financeTracker.model.ExpenseDTO;
import com.techconative.financeTracker.model.FinanceDTO;
import com.techconative.financeTracker.model.Income;
import com.techconative.financeTracker.model.IncomeDTO;

@Mapper(componentModel = "spring")
public interface FinanceMapper {
	
	FinanceMapper MAPPER = Mappers.getMapper(FinanceMapper.class);
	
	Expense mapExpenseDTOtoExpense(ExpenseDTO expenseDTO);
	ExpenseDTO mapExpenseToExpenseDTO(Expense expense);
	Income mapIncomeDTOtoIncome(IncomeDTO incomeDTO);
	IncomeDTO mapIncometoIncomeDTO(Income income);
	BudgetDTO mapBudgetToBudgetDTO(Budget budget);
	Budget mapBudgetDTOtoBudget(BudgetDTO budgetDTO);
	
	List<FinanceDTO> mapExpensetoFinanceDTO(List<Expense> expense);
	List<FinanceDTO> mapIncometoFinanceDTO(List<Income> income);
}
