package com.example.searchservice.services.abstracts;

import com.example.searchservice.core.business.paging.PageInfo;
import com.example.searchservice.core.responses.GetListResponse;
import com.example.searchservice.entities.Customer;
import com.example.searchservice.services.dtos.responses.GetAllSearchCustomerResponse;

import java.util.List;
import java.util.Optional;

public interface FilterService {
    void add(Customer customer);

    void update(Customer customer);

    GetListResponse<GetAllSearchCustomerResponse> searchCustomers(Optional<Long> customerNumber, Optional<String> nationalityId, Optional<String> accountNumber,
                                                                  Optional<String> mobilePhone, Optional<String> firstName, Optional<String> lastName,
                                                                  Optional<String> orderNumber, PageInfo pageInfo);

    Customer getById(String customerId);

    void delete(String customerId);
}
