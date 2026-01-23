package com.example.spring_ai.dto;

public record Joke(
        String text,
        String topic,
        Double laughScore,
        Boolean isNsfw
) {
}
