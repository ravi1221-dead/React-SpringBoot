package com.example.restapi.Service;

import com.example.restapi.Model.DTO.ExpenseDTO;

import java.util.List;

public interface ExpenseService {

    List<ExpenseDTO> getAllExpenses();

    ExpenseDTO getExpenseByIdExpenseId(String expenseId);
}
