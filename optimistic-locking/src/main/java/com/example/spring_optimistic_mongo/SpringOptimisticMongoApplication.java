package com.example.spring_optimistic_mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringOptimisticMongoApplication implements CommandLineRunner {

    private final OptimisticLockService lockService;

    public static void main(String[] args) {
        SpringApplication.run(SpringOptimisticMongoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        lockService.simulateConflict();
    }

}
