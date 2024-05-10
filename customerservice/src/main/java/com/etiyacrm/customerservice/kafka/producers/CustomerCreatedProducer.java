package com.etiyacrm.customerservice.kafka.producers;

import com.etiya.common.events.CustomerCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomerCreatedProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreatedProducer.class);
    private final KafkaTemplate<String, CustomerCreatedEvent> kafkaTemplate;

    public CustomerCreatedProducer(KafkaTemplate<String, CustomerCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CustomerCreatedEvent customerCreatedEvent) {
        LOGGER.info(String.format("Customer added =>%s", customerCreatedEvent.toString()));

        Message<CustomerCreatedEvent> message = MessageBuilder.withPayload(customerCreatedEvent)
                .setHeader(KafkaHeaders.TOPIC, "customer-created")
                .build();

        kafkaTemplate.send(message);

    }

}
