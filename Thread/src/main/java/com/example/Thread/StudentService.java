package com.example.Thread;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
@RequiredArgsConstructor
@Slf4j
public class StudentService {
    private final StudentInfoService studentInfoService;

    public Student getStudentInfo() {
        try {
            long start = System.currentTimeMillis();

            CompletableFuture<String> nameFuture = studentInfoService.getName();
            CompletableFuture<String> collegeFuture = studentInfoService.getCollege();
            CompletableFuture<Long> idFuture = studentInfoService.getId();
            CompletableFuture.allOf(nameFuture, collegeFuture, idFuture).join();

            Student student = new Student(
                    idFuture.get(),
                    nameFuture.get(),
                    collegeFuture.get());
            long end = System.currentTimeMillis();
            log.info("Ended in {} ms", end - start);
            return student;
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
