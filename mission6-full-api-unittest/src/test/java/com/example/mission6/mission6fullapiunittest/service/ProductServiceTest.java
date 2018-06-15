package com.example.mission6.mission6fullapiunittest.service;

import com.example.mission6.mission6fullapiunittest.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @MockBean
    private ProductService productService;

    @Before
    public void setup() {
        productService = new ProductService();
    }

    @Test
    public void valid_check_product_available() throws Exception {
        assertTrue(productService.checkAvailable(
                new Product(3, "Monitor", 2_500, 7, 2)));

    }

    @Test
    public void valid_check_product_not_available() throws Exception {
        assertFalse(productService.checkAvailable(
                new Product(3, "Monitor", 2_500, 7, 8)));

    }

}
