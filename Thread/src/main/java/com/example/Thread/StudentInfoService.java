package com.example.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class StudentInfoService {

    public CompletableFuture<String> getName() throws InterruptedException{
        log.info("Getting Name...{}", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("Returning Name");
        return CompletableFuture.completedFuture("John Doe");
    }

    public CompletableFuture<String> getCollege() throws InterruptedException{
        log.info("Getting College...{}", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("Returning College");
        return CompletableFuture.completedFuture("CC");
    }

    public CompletableFuture<Long> getId() throws InterruptedException{
        log.info("Getting Id...{}", Thread.currentThread().getName());
        Thread.sleep(2000);
        log.info("Returning ID");
        return CompletableFuture.completedFuture(123L);
    }
}
