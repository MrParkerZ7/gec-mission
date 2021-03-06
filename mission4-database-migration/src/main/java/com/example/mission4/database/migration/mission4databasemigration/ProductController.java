package com.example.mission4.database.migration.mission4databasemigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/save/{name}/{price}/{quantity}")
    public List<Product> saveOne(@PathVariable("name") String name, @PathVariable("price") int price, @PathVariable("quantity") int quantity) {
        productRepository.save(new Product(name, price, quantity, 0));
        return productRepository.findAll();
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
