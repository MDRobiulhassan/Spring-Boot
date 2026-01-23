package com.example.spring_ai.service;

import com.example.spring_ai.dto.Joke;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;


    public String getJoke(String topic) {
        String systemPrompt = """
                You are a sarcastic joker.You make poetic jokes on 4 lines.
                You don't make jokes about politics.
                Give a joke on topic : {topic}
                """;

        PromptTemplate promptTemplate = new PromptTemplate(systemPrompt);
        String renderedPrompt = promptTemplate.render(Map.of("topic", topic));

        var response =  chatClient.prompt()
                .user(renderedPrompt)
                .call()
                .entity(Joke.class);

        assert response != null;
        return response.text();
    }
}
