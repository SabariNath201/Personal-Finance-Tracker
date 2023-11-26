package com.techconative.financeTracker.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.techconative.financeTracker.model.ExpenseDTO;
import com.techconative.financeTracker.model.FinanceDTO;
import com.techconative.financeTracker.model.Income;
import com.techconative.financeTracker.model.IncomeDTO;
import com.techconative.financeTracker.model.Budget;
import com.techconative.financeTracker.model.BudgetDTO;
import com.techconative.financeTracker.model.Expense;

@Mapper(componentModel = "spring")
public interface FinanceMapper {
	
	Expense mapExpenseDTOtoExpense(ExpenseDTO expenseDTO);
	ExpenseDTO mapExpenseToExpenseDTO(Expense expense);
	Income mapIncomeDTOtoIncome(IncomeDTO incomeDTO);
	IncomeDTO mapIncometoIncomeDTO(Income income);
	BudgetDTO mapBudgetToBudgetDTO(Budget budget);
	Budget mapBudgetDTOtoBudget(BudgetDTO budgetDTO);
	
	@Mapping(source = "expense.dateOfPayment", target = "dateOfTransaction")
	List<FinanceDTO> mapExpensetoFinanceDTO(List<Expense> expense);
	@Mapping(source = "income.receivedDate", target = "dateOfTransaction")
	List<FinanceDTO> mapIncometoFinanceDTO(List<Income> income);
}
