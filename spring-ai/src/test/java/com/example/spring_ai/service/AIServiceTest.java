package com.example.spring_ai.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AIServiceTest {

    @Autowired
    private AIService aiService;

    @Test
    public void testGetJoke(){
        var joke = aiService.getJoke("Dogs");
        System.out.println(joke);
    }

    @Test
    public void testEmbedText(){
        var embed = aiService.getEmbedding("Hello world");
        System.out.println(embed.length);
        for (float e : embed) {
            System.out.print(e + " ");
        }
    }

    @Test
    public void testStoreData(){
        aiService.ingestDataToVectorStore("This is a big data");
    }

    @Test
    public void testStoreDataList(){
        aiService.ingestDataToVectorStore();
    }

    @Test
    public void testSimilaritySearch(){
        var results = aiService.similaritySearch("Space Movie");
        for(var doc : results){
            System.out.println(doc);
        }
    }
}
