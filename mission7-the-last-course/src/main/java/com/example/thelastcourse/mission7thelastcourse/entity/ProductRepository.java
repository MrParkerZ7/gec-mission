package com.example.thelastcourse.mission7thelastcourse.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByPriceGreaterThan(int min);

    List<Product> findByPriceLessThan(int max);

    List<Product> findByPriceBetween(int min, int max);

}
