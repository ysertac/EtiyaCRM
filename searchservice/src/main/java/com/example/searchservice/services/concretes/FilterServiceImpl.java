package com.example.searchservice.services.concretes;

import com.example.searchservice.core.business.paging.PageInfo;
import com.example.searchservice.core.responses.GetListResponse;
import com.example.searchservice.entities.Customer;
import com.example.searchservice.repositories.FilterRepository;
import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.responses.GetAllSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;

    @Override
    public void add(Customer customer) {
        filterRepository.save(customer);
    }

    @Override
    public void update(Customer customer) {
        filterRepository.save(customer);
    }

    public Customer getById(String customerId) {
        return this.filterRepository.findByCustomerId(customerId);
    }

    @Override
    public void delete(String customerId) {
        filterRepository.deleteByCustomerId(customerId);
    }

    @Override
    public GetListResponse<GetAllSearchCustomerResponse> searchCustomers(Optional<Long> customerNumber, Optional<String> nationalityId, Optional<String> accountNumber,
                                                              Optional<String> mobilePhone, Optional<String> firstName, Optional<String> lastName,
                                                              Optional<String> orderNumber, PageInfo pageInfo) {
        GetListResponse<GetAllSearchCustomerResponse> response = new GetListResponse<>();
        Sort sort = Sort.by("customerNumber").ascending();
        Pageable pageable = PageRequest.of(pageInfo.getPage(), pageInfo.getSize(), sort);
        Page<Customer> customers = this.filterRepository.getFilteredCustomers(customerNumber, nationalityId, accountNumber,
                mobilePhone, firstName, lastName, orderNumber, pageable);
        response.setItems(convertCustomerToResponse(customers));
        response.setTotalElements(customers.getTotalElements());
        response.setTotalPage(customers.getTotalPages());
        response.setSize(customers.getSize());
        response.setHasNext(customers.hasNext());
        response.setHasPrevious(customers.hasPrevious());

        return response;
    }

    private List<GetAllSearchCustomerResponse> convertCustomerToResponse(Page<Customer> customers) {
        List<GetAllSearchCustomerResponse> filteredCustomers = new ArrayList<>();

        for (Customer customer : customers) {
            GetAllSearchCustomerResponse getAllSearchCustomerResponse = new GetAllSearchCustomerResponse();
            getAllSearchCustomerResponse.setCustomerId(customer.getCustomerId());
            getAllSearchCustomerResponse.setCustomerNumber(customer.getCustomerNumber());
            getAllSearchCustomerResponse.setNationalityId(customer.getNationalityId());
            getAllSearchCustomerResponse.setRole("customer");
            getAllSearchCustomerResponse.setFirstName(customer.getFirstName());
            getAllSearchCustomerResponse.setMiddleName(customer.getMiddleName());
            getAllSearchCustomerResponse.setLastName(customer.getLastName());
            filteredCustomers.add(getAllSearchCustomerResponse);
        }

        return filteredCustomers;
    }
}
