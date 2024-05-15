package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;

import java.util.List;
import java.util.Optional;

public interface FilterRepositoryService {
    List<Customer> getFilteredCustomers(Optional<Long> customerNumber,  Optional<String> nationalityId,
                                        Optional<String> accountNumber,  Optional<String> mobilePhone,  Optional<String> firstName,
                                        Optional<String> lastName,  Optional<String> orderNumber);
}
