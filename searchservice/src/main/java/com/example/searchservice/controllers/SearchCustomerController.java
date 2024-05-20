package com.example.searchservice.controllers;

import com.example.searchservice.core.business.paging.PageInfo;
import com.example.searchservice.core.responses.GetListResponse;
import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.responses.GetAllSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping("api/v1/searchcustomer")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public GetListResponse<GetAllSearchCustomerResponse> searchCustomer(
            Optional<Integer> page,
            Optional<Integer> size,
            Optional<Long> customerNumber,
            Optional<String> nationalityId,
            Optional<String> accountNumber,
            Optional<String> mobilePhone,
            Optional<String> firstName,
            Optional<String> lastName,
            Optional<String> orderNumber
    ) {
        return filterService.searchCustomers(customerNumber, nationalityId, accountNumber, mobilePhone,
                firstName, lastName, orderNumber, new PageInfo(page.get(), size.get()));
    }
}
