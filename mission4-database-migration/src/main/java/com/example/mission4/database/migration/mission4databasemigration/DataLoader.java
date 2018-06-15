package com.example.mission4.database.migration.mission4databasemigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        productRepository.save(new Product("Ipad",1000,7));
        productRepository.save(new Product("Pen",17,23));
        productRepository.save(new Product("Head Phone",490,12));
        productRepository.save(new Product("Monitor LED",2700,3));
        productRepository.save(new Product("Lan Cable",150,34));
        productRepository.save(new Product("Mouse Logitech",3900,2));
    }
}
