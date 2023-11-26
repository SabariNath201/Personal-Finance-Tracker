package com.techconative.financeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techconative.financeTracker.model.Budget;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Integer>{

}
