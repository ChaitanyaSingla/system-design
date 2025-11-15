package com.example.spring_optimistic_mongo;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document
public class Product {

    @Id
    private String id;

    private String name;

    private double price;

    @Version
    private Long version;  // This enables optimistic locking!
}
