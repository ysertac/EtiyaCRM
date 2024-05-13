package com.example.searchservice.services.concretes;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.repositories.FilterRepository;
import com.example.searchservice.services.abstracts.FilterService;
import com.example.searchservice.services.dtos.requests.PostSearchCustomerRequest;
import com.example.searchservice.services.dtos.responses.PostSearchCustomerResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {

    private FilterRepository filterRepository;
    private MongoTemplate mongoTemplate;

    @Override
    public void add(Customer customer) {
        filterRepository.save(customer);
    }

    @Override
    public List<PostSearchCustomerResponse> searchCustomers(PostSearchCustomerRequest postSearchCustomerRequest) {

        List<Customer> customers = getFilteredCustomers(postSearchCustomerRequest.getCustomerId(), postSearchCustomerRequest.getNationalityId(),
                postSearchCustomerRequest.getMobilePhone(), postSearchCustomerRequest.getFirstName(), postSearchCustomerRequest.getLastName());
        return convertCustomerToResponse(customers);
    }


    public List<Customer> getFilteredCustomers(String customerId, String nationalityId, String mobilePhone, String firstName, String lastName) {
        Query query = new Query();

        addCriteriaIfNotNullOrEmpty(query, "customerId", customerId);
        addCriteriaIfNotNullOrEmpty(query, "nationalityId", nationalityId);
        addCriteriaIfNotNullOrEmpty(query, "mobilePhone", mobilePhone);
        addCriteriaIfNotNullOrEmpty(query, "firstName", firstName);
        addCriteriaIfNotNullOrEmpty(query, "lastName", lastName);

        return mongoTemplate.find(query, Customer.class);
    }

    private void addCriteriaIfNotNullOrEmpty(Query query, String field, String value) {
        if (value != null && !value.isEmpty()) {
            query.addCriteria(Criteria.where(field).is(value));
        }
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
