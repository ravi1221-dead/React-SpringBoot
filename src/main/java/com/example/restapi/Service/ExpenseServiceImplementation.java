package com.example.restapi.Service;

import com.example.restapi.Exception.ResourceNotFoundException;
import com.example.restapi.Model.DTO.ExpenseDTO;
import com.example.restapi.Model.ExpenseRequest;
import com.example.restapi.Repository.ExpenseRepository;
import com.example.restapi.Model.Entity.ExpenseEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExpenseServiceImplementation implements ExpenseService{

    private final ExpenseRepository expenseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ExpenseDTO> getAllExpenses() {
        // call the repository method
        List<ExpenseEntity> list = expenseRepository.findAll();
        log.info ("printing the data from Repository", list);
        //convert the entity object to DTO object
        List<ExpenseDTO> listOfExpenses = list.stream()
                .map(expenseEntity -> mapToExpenseDTO(expenseEntity))
                .collect(Collectors.toList());
        // Return the list
        return listOfExpenses;

    }

    @Override
    public ExpenseDTO getExpenseByIdExpenseId(String expenseId) {
        ExpenseEntity expenseEntity = expenseRepository.findByExpenseId(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("expense not found with expense id" + expenseId));
        log.info ("printing the expense entity details {}", expenseEntity);
        return mapToExpenseDTO(expenseEntity);
    }

    private ExpenseDTO mapToExpenseDTO(ExpenseEntity expenseEntity){
        return modelMapper.map(expenseEntity, ExpenseDTO.class);
    }
}
