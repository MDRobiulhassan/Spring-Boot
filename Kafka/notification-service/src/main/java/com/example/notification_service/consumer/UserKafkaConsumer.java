package com.example.notification_service.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserKafkaConsumer {

    @KafkaListener(topics = "user-random_topic")
    public void handleUserRandomTopic(String message) {
        log.info("handleUserRandomTopic" + message);
    }

    @KafkaListener(topics = "user-random_topic")
    public void handleUserRandomTopic2(String message) {
        log.info("handleUserRandomTopic2" + message);
    }

    @KafkaListener(topics = "user-random_topic")
    public void handleUserRandomTopic3(String message) {
        log.info("handleUserRandomTopic3" + message);
    }
}
