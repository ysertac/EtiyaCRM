package com.example.searchservice.controllers;

import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("searchservice/api/v1/searchcustomer")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostSearchCustomerResponse> searchCustomer(
            @RequestParam(required = false) String customerId,
            @RequestParam(required = false) String nationalityId,
            @RequestParam(required = false) String accountNumber,
            @RequestParam(required = false) String mobilePhone,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String orderNumber
    ) {
        return filterService.searchCustomers(customerId, nationalityId, accountNumber, mobilePhone, firstName, lastName, orderNumber);
    }
}
