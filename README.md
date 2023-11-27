# Personal-Finance-Tracker
Spring Boot based RESTful API service for a basic Personal Finance Tracker

Based on the Requirements given, I have created a Springboot Application with RESTful API service for Personal Finance Tracker.

Instructions:

1. I have added 'financeTrackerDB' sql file inside the Documents folder. Kindly run the full query in MySQL workbench.
2. Pull code to local.
3. Open cmd prompt from file directory eg: Techconative project\financeTracker>
4. Run cmd mvn clean install and mvn spring-boot:run
5. Application will start running in http://localhost:8888 (as configured in application.properties)

APIs:

1. GET - http://localhost:8888/api/expenses/{expenseId} - returns expense details for given expense id
2. POST - http://localhost:8888/api/expenses with request body. Sample request body attached in file 'create Expense request' inside Documents folder - Stores and returns expense details
3. PUT - http://localhost:8888/api/expenses/{expenseId} with request body. Sample request body attached in file 'create Expense request' inside Documents folder -returns updated expense details
4. DELETE - http://localhost:8888/api/expenses/{expenseId} - deletes expense details of that particular expenseID
5. POST - http://localhost:8888/api/incomes with request body. Sample request body attached in file 'create Income request' inside Documents folder - Stores and returns income details
6. GET - http://localhost:8888/api/reports - returns both expense and income sorted with dateOfTransaction. sample response attached in file 'financialReport Response' inside Documents folder
7. POST - http://localhost:8888/api/budgets - stores and returns the budget details. sample request and response attached in files 'create budget request','budget response' inside Documents folder
8. GET - http://localhost:8888/api/budgets/{budgetId} -  returns budget details for given budget Id
9. GET - http://localhost:8888/api/books?bookFilter=incomeBook,budgetBook,expenseBook- returns all details stored in database based on the bookFilter queryparam

