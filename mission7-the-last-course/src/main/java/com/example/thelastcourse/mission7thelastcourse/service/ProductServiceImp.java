package com.example.thelastcourse.mission7thelastcourse.service;

import com.example.thelastcourse.mission7thelastcourse.entity.Product;
import com.example.thelastcourse.mission7thelastcourse.entity.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductServiceImp implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product composeProduct(List<Product> products, String name, Integer price, Integer quantity) {
        products.forEach(product -> {
            if (!(product.getQuantity() > quantity))
                throw new IllegalStateException("Quantity of product can't be less then quantity of new product.");
        });

        {
            List<Product> productsRemain = new ArrayList<>();
            products.forEach(product -> {
                product.setQuantity(product.getQuantity() - quantity);
                productsRemain.add(product);
            });
            productRepository.saveAll(productsRemain);
        }
        return new Product(name, price, quantity);
    }
}
