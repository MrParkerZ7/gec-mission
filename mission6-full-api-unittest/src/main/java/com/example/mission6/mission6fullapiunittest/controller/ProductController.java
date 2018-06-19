package com.example.mission6.mission6fullapiunittest.controller;

import com.example.mission6.mission6fullapiunittest.domain.Product;
import com.example.mission6.mission6fullapiunittest.domain.ProductRepository;
import com.example.mission6.mission6fullapiunittest.service.ProductService;
import com.example.mission6.mission6fullapiunittest.service.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable("id") int id) {
        return productRepository.findById(id);
    }

    @GetMapping("/reservation/{id}")
    public String reservationProduct(@PathVariable("id") int id) {
        return productService.transaction(productRepository.findById(id), Status.RESERVATION);
    }

    @GetMapping("/buy/{id}")
    public String buyProduct(@PathVariable("id") int id) {
        return productService.transaction(productRepository.findById(id), Status.BUY);
    }

}
