package com.techconative.financeTracker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.techconative.financeTracker.model.ApplicationExceptionModel;
import com.techconative.financeTracker.model.Expense;
import com.techconative.financeTracker.model.ExpenseDTO;
import com.techconative.financeTracker.repository.ExpenseRepository;
import com.techconative.financeTracker.service.ExpenseServiceImpl;
import com.techconative.financeTracker.service.FinanceServiceImpl;

@SpringBootTest(classes = com.techconative.financeTracker.FinanceTrackerApplication.class)
@AutoConfigureMockMvc
class FinanceTrackerApplicationTests {
	
	@Autowired private MockMvc mockMvc;
	@InjectMocks ExpenseServiceImpl expenseService;
	@InjectMocks FinanceServiceImpl financeService;
	@MockBean ExpenseRepository expenseRepository;
	
	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
	}
	
	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		return objectMapper.registerModule(new JavaTimeModule());
	}
	
	@Test
	void getExpenseTest() throws Exception{
		Mockito.when(expenseRepository.existsById(Mockito.anyInt())).thenReturn(true);
		
		Optional<Expense> expenseResponse = Optional.of(getExpenseFromDB());
		Mockito.when(expenseRepository.findById(Mockito.anyInt())).thenReturn(expenseResponse);
		
		MvcResult mvcResult = mockMvc
							.perform(
									MockMvcRequestBuilders.get("http://localhost:8888/api/expenses/1")
									.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		ExpenseDTO expenseDTO =getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), ExpenseDTO.class);
		assertEquals(2000.0, expenseDTO.getAmountDebited());
	}
	
	@Test
	void deleteExpenseTest() throws Exception{
		Mockito.when(expenseRepository.existsById(Mockito.anyInt())).thenReturn(true);
		MvcResult mvcResult = mockMvc
							.perform(
									MockMvcRequestBuilders.delete("http://localhost:8888/api/expenses/1000")
									.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
	}
	
	@Test
	void deleteExpenseTest_InvalidExpenseID() throws Exception{
		Mockito.when(expenseRepository.existsById(Mockito.anyInt())).thenReturn(false);
		MvcResult mvcResult = mockMvc
							.perform(
									MockMvcRequestBuilders.delete("http://localhost:8888/api/expenses/1000")
									.contentType(MediaType.APPLICATION_JSON)).andReturn();
		
		assertEquals(404, mvcResult.getResponse().getStatus());
		ApplicationExceptionModel exceptionModel =getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), ApplicationExceptionModel.class);
		assertEquals("E4040", exceptionModel.getErrorCode());
		assertEquals("Expense details not found for given Expense Id : 1000", exceptionModel.getErrorMessage());
	}
	
	@Test
	void createExpenseTest() throws Exception{
		
		String createExpenseString = "{\n"
				+ "    \"dateOfTransaction\": \"2023-11-21\",\n"
				+ "    \"paidTo\": \"Ganesh Departments\",\n"
				+ "    \"description\": \"Groceries\",\n"
				+ "    \"amountDebited\": 2000.0\n"
				+ "}";
		MvcResult mvcResult = mockMvc
							.perform(
									MockMvcRequestBuilders.post("http://localhost:8888/api/expenses")
									.contentType(MediaType.APPLICATION_JSON)
									.content(createExpenseString)).andReturn();
		
		assertEquals(201, mvcResult.getResponse().getStatus());
		ExpenseDTO expenseDTO =getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), ExpenseDTO.class);
		assertEquals(2000.0, expenseDTO.getAmountDebited());
		assertEquals("Groceries", expenseDTO.getDescription());
	}
	
	@Test
	void updateExpenseTest() throws Exception{
		Mockito.when(expenseRepository.existsById(Mockito.anyInt())).thenReturn(true);
		Optional<Expense> expenseResponse = Optional.of(getUpdatedExpenseFromDB());
		Mockito.when(expenseRepository.findById(Mockito.anyInt())).thenReturn(expenseResponse);
		String updateExpenseString = "{\n"
				+ "    \"dateOfTransaction\": \"2023-11-21\",\n"
				+ "    \"paidTo\": \"Ganesh Departments\",\n"
				+ "    \"description\": \"Groceries\",\n"
				+ "    \"amountDebited\": 2000.0\n"
				+ "}";
		MvcResult mvcResult = mockMvc
							.perform(
									MockMvcRequestBuilders.put("http://localhost:8888/api/expenses/1")
									.contentType(MediaType.APPLICATION_JSON)
									.content(updateExpenseString)).andReturn();
		
		assertEquals(200, mvcResult.getResponse().getStatus());
		ExpenseDTO expenseDTO =getObjectMapper().readValue(mvcResult.getResponse().getContentAsString(), ExpenseDTO.class);
		assertEquals(2500.0, expenseDTO.getAmountDebited());
	}
	
	

	private Expense getExpenseFromDB() {
		Expense expense = new Expense();
		expense.setExpenseId(1);
		expense.setAmountDebited(2000.0);
		expense.setDateOfTransaction(LocalDate.now());
		expense.setDescription("Groceries");
		expense.setPaidTo("Ganesh Departments");
		return expense;
	}
	
	private Expense getUpdatedExpenseFromDB() {
		Expense expense = new Expense();
		expense.setExpenseId(1);
		expense.setAmountDebited(2500.0);
		expense.setDateOfTransaction(LocalDate.now());
		expense.setDescription("Groceries");
		expense.setPaidTo("Ganesh Departments");
		return expense;
	}
}
