package com.example.searchservice.services.abstracts;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;

import java.util.List;

public interface FilterService {
    void add(Customer customer);

    List<PostSearchCustomerResponse> searchCustomers(String customerId, String nationalityId, String accountNumber, String mobilePhone,
                                                     String firstName, String lastName, String orderNumber);
}
