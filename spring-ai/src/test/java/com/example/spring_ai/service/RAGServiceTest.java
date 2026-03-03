package com.example.spring_ai.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RAGServiceTest {

    @Autowired
    private RAGService ragService;

    @Test
    public void testAskAI() {
        var response = ragService.askAI("Need to report a violation");
        System.out.println(response);
    }

    @Test
    public void testIngest() {
        ragService.ingestPdfToVectorStore();
    }
}
