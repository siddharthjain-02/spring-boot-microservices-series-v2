/*** Licensed under MIT License Copyright (c) 2021-2023 Raja Kolli. ***/

package com.example.catalogservice.repositories;

import com.example.catalogservice.entities.Product;
import java.util.List;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Mono;

public interface ProductRepository
        extends ReactiveCrudRepository<Product, Long>, ReactiveSortingRepository<Product, Long> {

    Mono<Long> countDistinctByCodeAllIgnoreCaseIn(List<String> code);

    Mono<Product> findByCodeAllIgnoreCase(String code);
}
