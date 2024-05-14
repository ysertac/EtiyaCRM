package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

public class FilterRepositoryServiceImpl implements FilterRepositoryService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<Customer> getFilteredCustomers(String customerId, String nationalityId, String accountNumber, String mobilePhone, String firstName, String lastName, String orderNumber) {
        Query query = new Query();
        if (customerId != null) {
            query.addCriteria(Criteria.where("customerId").is(customerId));
        }
        if (nationalityId != null) {
            query.addCriteria(Criteria.where("nationalityId").is(nationalityId));
        }
        if (accountNumber != null) {
            query.addCriteria(Criteria.where("accountNumber").is(accountNumber));
        }
        if (mobilePhone != null) {
            query.addCriteria(Criteria.where("mobilePhone").is(mobilePhone));
        }
        if (firstName != null) {
            query.addCriteria(Criteria.where("firstName").is(firstName));
        }
        if (lastName != null) {
            query.addCriteria(Criteria.where("lastName").is(lastName));
        }
        if (orderNumber != null) {
            query.addCriteria(Criteria.where("orderNumber").is(orderNumber));
        }
        return mongoTemplate.find(query, Customer.class);
    }
}
