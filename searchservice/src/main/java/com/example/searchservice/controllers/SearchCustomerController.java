package com.example.searchservice.controllers;

import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("searchservice/api/v1/searchcustomer")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostSearchCustomerResponse> searchCustomer(
            Optional<Long> customerNumber,
            Optional<String> nationalityId,
            Optional<String> accountNumber,
            Optional<String> mobilePhone,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> orderNumber
    ) {
        return filterService.searchCustomers(customerNumber, nationalityId, accountNumber, mobilePhone, firstName, lastName, orderNumber);
    }
}
