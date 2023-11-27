
create schema financeTrackerDB;
use financeTrackerDB;

DROP TABLE IF EXISTS `budget`;

CREATE TABLE `budget` (
  `budget_Id` int NOT NULL,
  `income` double DEFAULT NULL,
  `rent_Expense` double DEFAULT NULL,
  `food_Expense` double DEFAULT NULL,
  `insurance_Expense` double DEFAULT NULL,
  `savings` double DEFAULT NULL,
  PRIMARY KEY (`budget_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `expense`;

CREATE TABLE `expense` (
  `expense_Id` int NOT NULL,
  `date_of_payment` date DEFAULT NULL,
  `paid_to` varchar(20) DEFAULT NULL,
  `description` varchar(40) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`expense_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `income`;

CREATE TABLE `income` (
  `income_id` int NOT NULL,
  `received_date` date DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `description` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`income_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



