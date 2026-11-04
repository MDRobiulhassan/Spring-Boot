package com.example.user_service_event.event;

import lombok.Data;

@Data
public class UserCreatedEvent {

    private Long id;
    private String name;
    private String email;
}
