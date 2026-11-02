package com.example.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.user-random_topic}")
    private String KAFKA_TOPIC_USER_RANDOM;

    @Bean
    public NewTopic userRandomTopic(){
        return new NewTopic("user_random_topic",1,(short) 1);
    }
}
