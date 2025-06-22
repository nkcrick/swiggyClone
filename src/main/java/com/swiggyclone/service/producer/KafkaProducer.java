package com.swiggyclone.service.producer;

import com.swiggyclone.event.OrderEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderStatus(OrderEvent order) {
        kafkaTemplate.send("order-status", order);
    }
}
