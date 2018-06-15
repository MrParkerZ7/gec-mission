package com.example.mission6.mission6fullapiunittest.component;

import com.example.mission6.mission6fullapiunittest.domain.Product;
import com.example.mission6.mission6fullapiunittest.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
//        productRepository.save(new Product(1, "Ipad", 3000, 3, 0));
//        productRepository.save(new Product(2, "Paper", 1, 23_000, 2_000));
//        productRepository.save(new Product(3, "Monitor", 2_500, 7, 2));
//        productRepository.save(new Product(4, "Mouse Logitech G403", 3_900, 0, 0));
//        productRepository.save(new Product(5, "Head Phone", 390, 14, 4));
//        productRepository.save(new Product(6, "Macbook Pro", 7_900, 4, 4));

    }
}
