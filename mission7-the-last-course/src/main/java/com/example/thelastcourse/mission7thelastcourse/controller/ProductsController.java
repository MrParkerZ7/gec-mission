package com.example.thelastcourse.mission7thelastcourse.controller;

import com.example.thelastcourse.mission7thelastcourse.entity.Product;
import com.example.thelastcourse.mission7thelastcourse.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<List<Product>>(productRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<String> insertOne(@RequestBody Product product) {
        if (product.getId() == null || !productRepository.existsById(product.getId())) {
            productRepository.save(product);
            return new ResponseEntity<String>("Save Successfully", HttpStatus.OK);
        } else return new ResponseEntity<>("ID Duplicated", HttpStatus.NOT_ACCEPTABLE);
    }

    @PutMapping
    private ResponseEntity<String> updateOne(@RequestBody Product product) {
        if (product.getId() != null && productRepository.existsById(product.getId())) {
            productRepository.save(product);
            return new ResponseEntity<String>("Update Successfully", HttpStatus.OK);
        } else return new ResponseEntity<>("Product Not Found", HttpStatus.NOT_FOUND);
    }
}
