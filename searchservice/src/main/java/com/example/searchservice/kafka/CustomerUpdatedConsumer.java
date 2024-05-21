package com.example.searchservice.kafka;

import com.etiya.common.events.CustomerCreatedEvent;
import com.etiya.common.events.CustomerUpdatedEvent;
import com.example.searchservice.entities.Customer;
import com.example.searchservice.services.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerUpdatedConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerUpdatedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-updated", groupId = "update-customer")
    private void consume(CustomerUpdatedEvent customerUpdatedEvent) {
        Customer customer = filterService.getById(customerUpdatedEvent.getCustomerId());
        customer.setCustomerId(customerUpdatedEvent.getCustomerId());
        customer.setFirstName(customerUpdatedEvent.getFirstName());
        customer.setMiddleName(customerUpdatedEvent.getMiddleName());
        customer.setLastName(customerUpdatedEvent.getLastname());
        customer.setNationalityId(customerUpdatedEvent.getNationalityId());
        LOGGER.info(String.format("Customer updated event consumer => %s", customerUpdatedEvent.toString()));
        filterService.update(customer);
    }
}
