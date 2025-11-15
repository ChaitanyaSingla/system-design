package com.example.spring_pessimistic_postgresql;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LockService {

    private final ProductRepository repo;

    public void createProduct() {
        Product product = Product.builder()
                .id(1L)
                .name("Macbook Pro")
                .quantity(100)
                .build();
        repo.save(product);
    }

    @Transactional
    public void transaction1() {
        System.out.println("Tx1 acquiring lock...");
        Product p = repo.lockProductForUpdate(1L);

        System.out.println("Tx1 got lock, sleeping...");
        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {

        }

        p.setQuantity(p.getQuantity() - 10);
        repo.save(p);

        System.out.println("Tx1 done.");
    }

    @Transactional
    public void transaction2() {
        System.out.println("Tx2 acquiring lock...");
        Product p = repo.lockProductForUpdate(1L);

        System.out.println("Tx2 got lock!");
        p.setQuantity(p.getQuantity() - 5);
        repo.save(p);

        System.out.println("Tx2 done.");
    }
}
