package com.techconative.financeTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techconative.financeTracker.model.Income;

@Repository
public interface IncomeRepository extends JpaRepository<Income, Integer>{

}
