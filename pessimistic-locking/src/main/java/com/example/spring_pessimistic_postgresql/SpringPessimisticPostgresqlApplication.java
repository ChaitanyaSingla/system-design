package com.example.spring_pessimistic_postgresql;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringPessimisticPostgresqlApplication implements CommandLineRunner {

    private final LockService service;

    public static void main(String[] args) {
        SpringApplication.run(SpringPessimisticPostgresqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        service.createProduct();
        new Thread(service::transaction1).start();
        Thread.sleep(2000);
        new Thread(service::transaction2).start();
    }

}
