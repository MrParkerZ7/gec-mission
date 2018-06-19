package com.example.mission6.mission6fullapiunittest.service;

import com.example.mission6.mission6fullapiunittest.domain.Product;
import com.example.mission6.mission6fullapiunittest.domain.ProductRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class ProductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void valid_check_product_available() throws Exception {
        ProductService productService = new ProductService();

        assertTrue(productService.checkAvailable(
                new Product(3, "Monitor", 2_500, 7, 2)));

    }

    @Test
    public void valid_check_product_not_available() throws Exception {
        ProductService productService = new ProductService();

        assertFalse(productService.checkAvailable(
                new Product(3, "Monitor", 2_500, 7, 7)));

    }

    @Test
    public void valid_transaction_successful() {
        ProductService productService = new ProductService();
        Product product = new Product(3, "Monitor", 2_500, 7, 2);

        assertEquals("Thank you!! Your transaction complete!!",
                productService.transaction(java.util.Optional.of(product), Status.BUY));
        assertEquals("Thank you!! Your transaction complete!!",
                productService.transaction(java.util.Optional.of(product), Status.RESERVATION));
    }

    @Test
    public void valid_transaction_no_left() {
        ProductService productService = new ProductService();
        Product product = new Product(3, "Monitor", 2_500, 5, 5);

        assertEquals("Sorry!! We have no product left for you.",
                productService.transaction(java.util.Optional.of(product), Status.BUY));
        assertEquals("Sorry!! We have no product left for you.",
                productService.transaction(java.util.Optional.of(product), Status.RESERVATION));
    }

    @Test
    public void valid_transaction_not_found() {
        ProductService productService = new ProductService();
        Product product = null;

        assertEquals("Your order not found!!",
                productService.transaction(java.util.Optional.ofNullable(product), Status.BUY));
        assertEquals("Your order not found!!",
                productService.transaction(java.util.Optional.ofNullable(product), Status.RESERVATION));
    }
}
