package com.example.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;

@RestController
@Slf4j
public class DummyController {

    @GetMapping("/hello")
    public ResponseEntity<?> getName() throws InterruptedException {
        log.info("Thread is Blocked for 5 seconds");
        Thread.sleep(5000);
        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/hello-cf")
    public CompletableFuture<ResponseEntity<?>> getNameCF() throws InterruptedException {
        log.info("Thread is Called");

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return ResponseEntity.ok("Hello World");
        }, Executors.newFixedThreadPool(4));
    }
}
