package com.example.searchservice.services.concretes;

import com.example.searchservice.entities.Customer;
import com.example.searchservice.repositories.FilterRepository;
import com.example.searchservice.services.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FilterServiceImpl implements FilterService {
    private FilterRepository filterRepository;
    @Override
    public void add(Customer customer) {
        filterRepository.save(customer);
    }
}
