package com.example.Thread;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Instant;
import java.util.concurrent.*;

@SpringBootApplication
@Slf4j
@EnableScheduling
@EnableAsync
public class ThreadApplication implements CommandLineRunner {

//    @Qualifier("taskScheduler")
//    @Autowired
//    private TaskScheduler taskScheduler;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SpringApplication.run(ThreadApplication.class, args);
//        learnFuture();
//        learnCompletableFuture();
//        learnCF2();
//        log.info("After Method Call");
    }

//    static void learnCompletableFuture() {
//        CompletableFuture<String> myNameCF = CompletableFuture.supplyAsync(ThreadApplication::getName)
//                .thenApply(String::toUpperCase)
//                .thenApply(String::length)
//                .thenApply(lengthOfName -> {
//                    log.info("Inside method with length");
//                    if (true)
//                        throw new RuntimeException("Faking error....");
//                    return "length of name is " + lengthOfName;
//                })
//                .exceptionally((err) -> {
//                    return "Default value due to error: " + err.getMessage();
//                });
//
//        myNameCF.thenAccept(name -> {
//            log.info("name is {}", name);
//        });
//    }
//
//    static void learnCF2() {
//        CompletableFuture<String> nameFuture = CompletableFuture.supplyAsync(ThreadApplication::getName);
//        CompletableFuture<String> addressFuture = CompletableFuture.supplyAsync(ThreadApplication::getAddress);
//
//        CompletableFuture.allOf(nameFuture, addressFuture);
//        log.info("Got the name : {} and address : {}", nameFuture.join(), addressFuture.join());
//    }
//
//    static String getName() {
//        try {
//            log.info("getName is {}", Thread.currentThread().getState());
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return "Robiul";
//    }
//
//    static String getAddress() {
//        try {
//            log.info("getAddress is {}", Thread.currentThread().getState());
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return "Chittagong";
//    }
//
//    static void learnThread() throws InterruptedException {
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
//    }
//
//    static void learnFuture() throws ExecutionException, InterruptedException {
//
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
//
//        try {
//            Future<String> myNameFuture = executorService.submit(() -> {
//                log.info("Inside name future: {}", Thread.currentThread().getState());
//
//                Thread.sleep(5000);
//
//                return "Robiul";
//            });
//
//            String name = myNameFuture.get();
//            log.info("Result: {}", name);
//
//        } finally {
//            executorService.shutdown();
//        }
//    }
//
//    @Override
    public void run(String... args) throws Exception {
//        taskScheduler.schedule(() -> {
//            log.info("Running Schedular Task");
//        }, Instant.ofEpochSecond(2));
////        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,
////                600, 2, TimeUnit.SECONDS,
////                new ArrayBlockingQueue<>(10),
////                new RejectedExecutionHandler() {
////                    @Override
////                    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
////                        log.info("Thread Rejected.....Retrying.....");
////                        try {
////                            Thread.sleep(1000);
////                        } catch (InterruptedException e) {
////                            throw new RuntimeException(e);
////                        }
////                        executor.submit(r);
////                    }
////                }
////        );
////
////        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(6,
////                new ThreadFactory() {
////                    @Override
////                    public Thread newThread(Runnable r) {
////                        log.info("");
////                        return new Thread(r, "thread " + System.nanoTime());
////                    }
////                });
////
////        scheduledThreadPoolExecutor.schedule(new LongRunningTask("scheduled"), 5, TimeUnit.SECONDS);
////
////
////        log.info("Starting main Thread -> {}", Thread.currentThread().getName());
////
////        for (int i = 0; i < 20; i++) {
////            threadPoolExecutor.submit(new LongRunningTask(i++ + ""));
////            Thread.sleep(1000);
////        }
////
////        log.info("Ending main Thread -> {}", Thread.currentThread().getName());
    }
}
