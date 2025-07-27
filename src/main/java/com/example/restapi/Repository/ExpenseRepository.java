package com.example.restapi.Repository;

import com.example.restapi.Model.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, Long> {
    // Use ExpenseEntity, not ExpenseRequest
    Optional<ExpenseEntity> findByExpenseId(String expenseId);
}
