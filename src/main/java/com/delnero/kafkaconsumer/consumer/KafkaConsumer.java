package com.delnero.kafkaconsumer.consumer;

import com.delnero.kafkaconsumer.model.Pizza;
import com.delnero.kafkaconsumer.service.PizzaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private static final String orderTopic = "${topic.name}";

    private final ObjectMapper objectMapper;

    private final PizzaService pizzaService;

    @Autowired
    public KafkaConsumer(ObjectMapper objectMapper, PizzaService pizzaService) {
        this.objectMapper = objectMapper;
        this.pizzaService = pizzaService;
    }

    @KafkaListener(topics = orderTopic)
    public void consumeMessage(String message) throws JsonProcessingException {
        log.info("message consumed {}", message);

        Pizza pizza = objectMapper.readValue(message, Pizza.class);
        pizzaService.save(pizza);
    }
}
