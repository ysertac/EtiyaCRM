package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public class FilterRepositoryServiceImpl implements FilterRepositoryService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Customer> getFilteredCustomers(Optional<String> customerId, Optional<String> nationalityId,
                                               Optional<String> accountNumber, Optional<String> mobilePhone, Optional<String> firstName,
                                               Optional<String> lastName, Optional<String> orderNumber) {
        Query query = new Query();
        customerId.ifPresent(s -> query.addCriteria(Criteria.where("customerId").is(s)));
        nationalityId.ifPresent(s -> query.addCriteria(Criteria.where("nationalityId").is(s)));
        accountNumber.ifPresent(s -> query.addCriteria(Criteria.where("accountNumber").is(s)));
        mobilePhone.ifPresent(s -> query.addCriteria(Criteria.where("mobilePhone").is(s)));
        firstName.ifPresent(s -> query.addCriteria(Criteria.where("firstName").regex("^" + s + "$", "i")));
        lastName.ifPresent(s -> query.addCriteria(Criteria.where("lastName").regex("^" + s + "$", "i")));
        orderNumber.ifPresent(s -> query.addCriteria(Criteria.where("orderNumber").is(s)));

        return mongoTemplate.find(query, Customer.class);
    }
}
