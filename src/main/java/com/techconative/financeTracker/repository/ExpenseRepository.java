package com.techconative.financeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techconative.financeTracker.model.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer>{

}
