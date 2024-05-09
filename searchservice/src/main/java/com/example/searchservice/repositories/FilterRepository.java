package com.example.searchservice.repositories;

import com.example.searchservice.entities.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FilterRepository extends MongoRepository<Customer, String> {
}
