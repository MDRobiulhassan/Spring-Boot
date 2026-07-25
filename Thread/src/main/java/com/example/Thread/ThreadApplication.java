package com.example.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.*;

@SpringBootApplication
@Slf4j
public class ThreadApplication implements CommandLineRunner {

    public static void main(String[] args) throws InterruptedException {

        SpringApplication.run(ThreadApplication.class, args);

//        log.info("Before Thread, Name of Thread : {}, State: {}", Thread.currentThread().getName(), Thread.currentThread().getState());
//
//        Thread workderThread = new Thread(() -> {
//            log.info("Inside the Thread");
//            log.info("Inside Thread, Name of Thread : {}, State: {}", Thread.currentThread().getName(), Thread.currentThread().getState());
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        });
//
//        workderThread.start();
//        workderThread.join();
//
//        log.info("After Thread, State of Worker: {}", workderThread.getState());
//        log.info("After Thread");
    }

    @Override
    public void run(String... args) throws Exception {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,
                600, 2, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10),
                new RejectedExecutionHandler() {
                    @Override
                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                        log.info("Thread Rejected.....Retrying.....");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        executor.submit(r);
                    }
                }
        );

        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(6,
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        log.info("");
                        return new Thread(r, "thread " + System.nanoTime());
                    }
                });

        scheduledThreadPoolExecutor.schedule(new LongRunningTask("scheduled"), 5, TimeUnit.SECONDS);


        log.info("Starting main Thread -> {}", Thread.currentThread().getName());

        for (int i = 0; i < 20; i++) {
            threadPoolExecutor.submit(new LongRunningTask(i++ + ""));
            Thread.sleep(1000);
        }

        log.info("Ending main Thread -> {}", Thread.currentThread().getName());
    }
}
