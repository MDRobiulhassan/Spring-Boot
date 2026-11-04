package com.example.user_service.controller;


import com.example.user_service.dto.CreateUserRequestDto;
import com.example.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final UserService userService;

    @Value("${kafka.topic.user-random_topic}")
    private String KAFKA_TOPIC_USER_RANDOM;

    @PostMapping("/{messages}")
    public ResponseEntity<?> sendMessage(@PathVariable String messages) {
        for (int i = 0; i < 1000; i++) {
            kafkaTemplate.send(KAFKA_TOPIC_USER_RANDOM, String.valueOf(i%2),messages + " " + i);
        }
        return ResponseEntity.ok("Message queued");
    }

    @PostMapping
    public  ResponseEntity<?> createUser(@RequestBody CreateUserRequestDto createUserRequestDto) {
        userService.createUser(createUserRequestDto);
        return ResponseEntity.ok("User Created");
    }
}
