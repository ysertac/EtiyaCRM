package com.example.searchservice.services.concretes;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.repositories.FilterRepository;
import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;

    @Override
    public void add(Customer customer) {
        filterRepository.save(customer);
    }

    @Override
    public List<PostSearchCustomerResponse> searchCustomers(Optional<Long> customerNumber,  Optional<String> nationalityId,
                                                            Optional<String> accountNumber,  Optional<String> mobilePhone,
                                                            Optional<String> firstName,  Optional<String> lastName,  Optional<String> orderNumber) {

        List<Customer> customers = this.filterRepository.getFilteredCustomers(customerNumber, nationalityId, accountNumber,
                mobilePhone, firstName, lastName, orderNumber);
        return convertCustomerToResponse(customers);
    }

    private List<PostSearchCustomerResponse> convertCustomerToResponse(List<Customer> customers) {
        List<PostSearchCustomerResponse> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            PostSearchCustomerResponse postSearchCustomerResponse = new PostSearchCustomerResponse();
            postSearchCustomerResponse.setCustomerId(customer.getCustomerId());
            postSearchCustomerResponse.setCustomerNumber(customer.getCustomerNumber());
            postSearchCustomerResponse.setNationalityId(customer.getNationalityId());
            postSearchCustomerResponse.setRole("customer");
            postSearchCustomerResponse.setFirstName(customer.getFirstName());
            postSearchCustomerResponse.setMiddleName(customer.getMiddleName());
            postSearchCustomerResponse.setLastName(customer.getLastName());
            filteredCustomers.add(postSearchCustomerResponse);
        }
        return filteredCustomers;
    }
}
