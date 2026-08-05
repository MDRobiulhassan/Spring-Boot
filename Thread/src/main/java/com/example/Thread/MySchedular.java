package com.example.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MySchedular {

    @Scheduled(fixedRate = 200)
    @Async("jobExecutor")
//    @Scheduled(fixedDelay = 2000,initialDelay = 10000)
    void logMe() {
        log.info("Schedular1 Started.....{}", Thread.currentThread().getName());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("Schedular1 Ended.......{}", Thread.currentThread().getName());
    }

//    @Scheduled(fixedRate = 1000)
//    void logYou() {
//        log.info("Schedular2 Started.....{}",Thread.currentThread().getName());
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//        log.info("Schedular2 Ended.......{}",Thread.currentThread().getName());
//    }
}
