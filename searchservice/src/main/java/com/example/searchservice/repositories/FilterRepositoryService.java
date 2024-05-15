package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FilterRepositoryService {
    Page<Customer> getFilteredCustomers(Optional<Long> customerNumber, Optional<String> nationalityId,
                                        Optional<String> accountNumber, Optional<String> mobilePhone, Optional<String> firstName,
                                        Optional<String> lastName, Optional<String> orderNumber, Pageable pageable);
}
