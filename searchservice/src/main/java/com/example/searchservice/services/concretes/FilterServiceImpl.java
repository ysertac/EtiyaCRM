package com.example.searchservice.services.concretes;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.repositories.FilterRepository;
import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;

    @Override
    public void add(Customer customer) {
        filterRepository.save(customer);
    }

    @Override
    public List<PostSearchCustomerResponse> searchCustomers(String customerId, String nationalityId, String accountNumber, String mobilePhone,
                                                            String firstName, String lastName, String orderNumber) {

        List<Customer> customers = this.filterRepository.getFilteredCustomers(customerId, nationalityId, accountNumber,
                mobilePhone, firstName, lastName, orderNumber);
        return convertCustomerToResponse(customers);
    }

    private List<PostSearchCustomerResponse> convertCustomerToResponse(List<Customer> customers) {
        List<PostSearchCustomerResponse> filteredCustomers = new ArrayList<>();
        for (Customer customer : customers) {
            PostSearchCustomerResponse postSearchCustomerResponse = new PostSearchCustomerResponse();
            postSearchCustomerResponse.setCustomerId(customer.getCustomerId());
            postSearchCustomerResponse.setNationalityId(customer.getNationalityId());
            postSearchCustomerResponse.setAccountNumber("1234567");
            postSearchCustomerResponse.setMobilePhone(customer.getMobilePhone());
            postSearchCustomerResponse.setFirstName(customer.getFirstName());
            postSearchCustomerResponse.setLastName(customer.getLastname());
            postSearchCustomerResponse.setOrderNumber("987654");
            filteredCustomers.add(postSearchCustomerResponse);
        }
        return filteredCustomers;
    }
}
