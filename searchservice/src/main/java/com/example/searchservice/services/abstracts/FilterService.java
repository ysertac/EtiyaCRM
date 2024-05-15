package com.example.searchservice.services.abstracts;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;

import java.util.List;
import java.util.Optional;

public interface FilterService {
    void add(Customer customer);

    List<PostSearchCustomerResponse> searchCustomers(Optional<Long> customerNumber, Optional<String> nationalityId,
                                                     Optional<String> accountNumber, Optional<String> mobilePhone,
                                                     Optional<String> firstName, Optional<String> lastName, Optional<String> orderNumber);
}
