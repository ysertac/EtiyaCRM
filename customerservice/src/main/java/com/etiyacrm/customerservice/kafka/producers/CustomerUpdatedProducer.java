package com.etiyacrm.customerservice.kafka.producers;

import com.etiya.common.events.CustomerUpdatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomerUpdatedProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerUpdatedProducer.class);
    private final KafkaTemplate<String, CustomerUpdatedEvent> kafkaTemplate;

    public CustomerUpdatedProducer(KafkaTemplate<String, CustomerUpdatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CustomerUpdatedEvent customerUpdatedEvent) {
        LOGGER.info(String.format("Customer updated =>%s", customerUpdatedEvent.toString()));

        Message<CustomerUpdatedEvent> message = MessageBuilder.withPayload(customerUpdatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "customer-updated")
                .build();

        kafkaTemplate.send(message);

    }
}
