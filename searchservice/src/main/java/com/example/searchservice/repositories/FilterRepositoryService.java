package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;

import java.util.List;

public interface FilterRepositoryService {
    List<Customer> getFilteredCustomers(String customerId, String nationalityId, String accountNumber, String mobilePhone, String firstName, String lastName, String orderNumber);
}
