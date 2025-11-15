package com.example.spring_optimistic_mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OptimisticLockService {

    private final ProductRepository repo;

    public void simulateConflict() {

        Product product = Product.builder()
                .name("Macbook Pro")
                .price(100)
                .build();

        product = repo.save(product);

        // Transaction 1 reads product
        Product p1 = repo.findById(product.getId()).get();

        // Transaction 2 reads product
        Product p2 = repo.findById(product.getId()).get();

        // Transaction 2 updates first (OK)
        p2.setPrice(50);
        System.out.println("Saving p2 first...");
        repo.save(p2);    // version becomes 1

        // Transaction 1 tries to update stale version (FAIL)
        try {
            System.out.println("Saving p1 now (should fail)...");
            p1.setPrice(30);
            repo.save(p1);  // throws OptimisticLockingFailureException
        } catch (OptimisticLockingFailureException ex) {
            System.out.println("Conflict detected! Someone else modified this record.");
        }
    }
}
