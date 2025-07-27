package com.example.restapi.Controller;

import com.example.restapi.Model.DTO.ExpenseDTO;
import com.example.restapi.Service.ExpenseService;
import com.example.restapi.Model.ExpenseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * REST Controller for expense operations.
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin("*")
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

    /**
     * Get all expenses.
     */
    @GetMapping("/expenses")
    public List<ExpenseResponse> getExpenses(){
        log.info("API GET /expenses called");

        //call the service method
        List<ExpenseDTO> list = expenseService.getAllExpenses();
        log.info("printing data from service", list);
        // convert expenseDTO to Expense Response
        List<ExpenseResponse> response = list.stream()
                .map(expenseDTO -> mapToExpenseResponse(expenseDTO))
                .collect(Collectors.toList());
        //return the list/response
        return response;
    }

    /**
     * Get expense by ID.
     *
     * @param expenseId The expense ID
     */
    @GetMapping("/expenses/{expenseId}")
    public ExpenseResponse getExpenseById(@PathVariable String expenseId){
        log.info("API GET /expenses/{} called", expenseId);
        ExpenseDTO expenseDTO = expenseService.getExpenseByIdExpenseId(expenseId);
        log.info("printing the expense details", expenseDTO);
        return  mapToExpenseResponse(expenseDTO);
    }

    /**
     * Maps an ExpenseDTO object to an ExpenseResponse object.
     * @param expenseDTO The ExpenseDTO object to be converted
     * @return ExpenseResponse object mapped from the input DTO
     * @throws IllegalArgumentException if expenseDTO is null
     */
    public ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO){
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}