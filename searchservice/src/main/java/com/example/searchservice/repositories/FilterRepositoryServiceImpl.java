package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public class FilterRepositoryServiceImpl implements FilterRepositoryService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Customer> getFilteredCustomers(Optional<Long> customerNumber, Optional<String> nationalityId,
                                               Optional<String> accountNumber, Optional<String> mobilePhone, Optional<String> firstName,
                                               Optional<String> lastName, Optional<String> orderNumber, Pageable pageable) {
        Query query = new Query();
        customerNumber.ifPresent(s -> query.addCriteria(Criteria.where("customerNumber").is(s)));
        nationalityId.ifPresent(s -> query.addCriteria(Criteria.where("nationalityId").is(s)));
        accountNumber.ifPresent(s -> query.addCriteria(Criteria.where("accountNumber").is(s)));
        mobilePhone.ifPresent(s -> query.addCriteria(Criteria.where("mobilePhone").is(s)));
        firstName.ifPresent(s -> query.addCriteria(Criteria.where("firstName").regex("^" + s + "$", "i")));
        lastName.ifPresent(s -> query.addCriteria(Criteria.where("lastName").regex("^" + s + "$", "i")));
        orderNumber.ifPresent(s -> query.addCriteria(Criteria.where("orderNumber").is(s)));

        List<Customer> customers;
        customers = mongoTemplate.find(query, Customer.class);
        query.with(pageable);
        long total = customers.size();
        customers = mongoTemplate.find(query, Customer.class);
        return new PageImpl<>(customers, pageable, total);
    }
}
