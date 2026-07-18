package com.example.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ThreadApplication {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(ThreadApplication.class, args);

        log.info("Before Thread, Name of Thread : {}, State: {}", Thread.currentThread().getName(), Thread.currentThread().getState());

        Thread workderThread = new Thread(() -> {
            log.info("Inside the Thread");
            log.info("Inside Thread, Name of Thread : {}, State: {}", Thread.currentThread().getName(), Thread.currentThread().getState());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        workderThread.start();
        workderThread.join();

        log.info("After Thread, State of Worker: {}", workderThread.getState());
        log.info("After Thread");
    }

}
