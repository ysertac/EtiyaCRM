package com.example.searchservice.controllers;

import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.requests.PostSearchCustomerRequest;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("searchservice/api/v1/searchcustomer")
@AllArgsConstructor
public class SearchCustomerController {
    private FilterService filterService;

    @PostMapping
    public List<PostSearchCustomerResponse> searchCustomer(@RequestBody PostSearchCustomerRequest postSearchCustomerRequest) {
        PostSearchCustomerResponse postSearchCustomerResponse = new PostSearchCustomerResponse();
        postSearchCustomerResponse.setCustomerId(postSearchCustomerRequest.getCustomerId());
        postSearchCustomerResponse.setFirstName(postSearchCustomerRequest.getFirstName());
        postSearchCustomerResponse.setLastName(postSearchCustomerRequest.getLastName());
        postSearchCustomerResponse.setMobilePhone(postSearchCustomerRequest.getMobilePhone());
        postSearchCustomerResponse.setOrderNumber(postSearchCustomerRequest.getOrderNumber());
        postSearchCustomerResponse.setNationalityId(postSearchCustomerRequest.getNationalityId());
        postSearchCustomerResponse.setAccountNumber(postSearchCustomerRequest.getAccountNumber());
        List postSearchCustomerResponseList = new ArrayList();
        postSearchCustomerResponseList.add(postSearchCustomerResponse);
        return postSearchCustomerResponseList;
    }
}
