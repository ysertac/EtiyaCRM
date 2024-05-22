package com.example.searchservice.kafka;

import com.etiya.common.events.CustomerDeletedEvent;
import com.example.searchservice.services.abstracts.FilterService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerDeletedConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDeletedConsumer.class);
    private FilterService filterService;

    @KafkaListener(topics = "customer-deleted", groupId = "delete-customer")
    private void consume(CustomerDeletedEvent customerDeletedEvent) {
        LOGGER.info(String.format("Customer deleted event consumer => %s", customerDeletedEvent.toString()));
        filterService.delete(customerDeletedEvent.getCustomerId());
    }
}
