package com.example.searchservice.services.abstracts;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.services.dtos.requests.PostSearchCustomerRequest;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;

import java.util.List;

public interface FilterService {
    void add(Customer customer);
    List<PostSearchCustomerResponse> searchCustomers(PostSearchCustomerRequest postSearchCustomerRequest);
}
