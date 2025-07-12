package com.example.restapi.Controller;

import com.example.restapi.Model.DTO.ExpenseDTO;
import com.example.restapi.Service.ExpenseService;
import com.example.restapi.Model.ExpenseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ExpenseController {

    private final ExpenseService expenseService;
    private final ModelMapper modelMapper;

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

    public ExpenseResponse mapToExpenseResponse(ExpenseDTO expenseDTO){
        return modelMapper.map(expenseDTO, ExpenseResponse.class);
    }
}
