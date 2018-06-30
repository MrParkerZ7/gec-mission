package com.example.thelastcourse.mission7thelastcourse.service;

import com.example.thelastcourse.mission7thelastcourse.entity.Product;
import com.example.thelastcourse.mission7thelastcourse.entity.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @Autowired
    private ProductService productService;

    @MockBean
    private ProductRepository productRepository;

    @Before
    public void setup() {

    }

    @TestConfiguration
    static class CProductServiceTestConfiguration {
        @Bean
        ProductService productService() {
            return new ProductServiceImp();
        }
    }

    @Test
    public void compose_product_successful() throws Exception {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Eraser", 5, 70),
                new Product(2, "Pen", 12, 50)
        ));

        Product newProduct = productService.composeProduct(products, "Stationary", 15, 40);


        assertNull(newProduct.getId());
        assertEquals("Stationary", newProduct.getName());
        assertEquals(java.util.Optional.of(15), java.util.Optional.of(newProduct.getPrice()));
        assertEquals(java.util.Optional.of(40), java.util.Optional.of(newProduct.getQuantity()));

    }

    @Test
    public void compose_product_Fail() throws Exception {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product(1, "Eraser", 5, 70),
                new Product(2, "Pen", 12, 50)
        ));

        try {
            Product newProduct = productService.composeProduct(products, "Stationary", 15, 70);
        } catch (IllegalStateException e) {
            assertEquals("Quantity of product can't be less then quantity of new product.", e.getMessage());
        }
    }
}
