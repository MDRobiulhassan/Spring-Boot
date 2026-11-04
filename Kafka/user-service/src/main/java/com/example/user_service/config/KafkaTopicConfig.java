package com.example.user_service.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.user-random_topic}")
    private String KAFKA_TOPIC_USER_RANDOM;

    @Value("${kafka.topic.user-created_topic}")
    private String KAFKA_USER_CREATED_TOPIC;

    @Bean
    public NewTopic userRandomTopic(){
        return new NewTopic(KAFKA_TOPIC_USER_RANDOM,1,(short) 1);
    }

    @Bean
    public NewTopic userCreatedTopic(){
        return new NewTopic(KAFKA_USER_CREATED_TOPIC,1,(short) 1);
    }
}
