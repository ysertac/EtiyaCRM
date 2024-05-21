package com.etiyacrm.customerservice.kafka.producers;

import com.etiya.common.events.CustomerCreatedEvent;
import com.etiya.common.events.CustomerDeletedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class CustomerDeletedProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerDeletedProducer.class);
    private final KafkaTemplate<String, CustomerDeletedEvent> kafkaTemplate;

    public CustomerDeletedProducer(KafkaTemplate<String, CustomerDeletedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(CustomerDeletedEvent customerDeletedEvent) {
        LOGGER.info(String.format("Customer deleted =>%s", customerDeletedEvent.toString()));

        Message<CustomerDeletedEvent> message = MessageBuilder.withPayload(customerDeletedEvent)
                .setHeader(KafkaHeaders.TOPIC, "customer-deleted")
                .build();

        kafkaTemplate.send(message);

    }
}
