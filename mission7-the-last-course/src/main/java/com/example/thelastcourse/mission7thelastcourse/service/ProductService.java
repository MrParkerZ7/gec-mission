package com.example.thelastcourse.mission7thelastcourse.service;

import com.example.thelastcourse.mission7thelastcourse.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    Product composeProduct(List<Product> products, String name, Integer price, Integer quantity);
}
