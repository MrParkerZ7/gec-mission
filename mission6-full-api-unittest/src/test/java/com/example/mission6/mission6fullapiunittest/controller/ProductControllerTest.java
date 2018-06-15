package com.example.mission6.mission6fullapiunittest.controller;

import com.example.mission6.mission6fullapiunittest.domain.Product;
import com.example.mission6.mission6fullapiunittest.domain.ProductRepository;
import com.example.mission6.mission6fullapiunittest.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @MockBean
    private ProductService productService;

    @Before
    public void setup() {
        productService = new ProductService();
    }

    @Test
    public void valid_get_all() throws Exception {
        when(productRepository.findAll()).thenReturn(
                new ArrayList<>(Arrays.asList(
                        new Product(1, "Ipad", 3000, 3, 0),
                        new Product(2, "Paper", 1, 23_000, 2_000),
                        new Product(3, "Monitor", 2_500, 7, 2),
                        new Product(4, "Mouse Logitech G403", 3_900, 0, 0),
                        new Product(5, "Head Phone", 390, 14, 4),
                        new Product(6, "Macbook Pro", 7_900, 4, 4)))
        );

        mockMvc.perform(MockMvcRequestBuilders.get("/all/")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)));

        verify(productRepository).findAll();
    }

    @Test
    public void valid_get_product_by_id() throws Exception {
        when(productRepository.findById(3))
                .thenReturn(java.util.Optional.of(new Product(3, "Monitor", 2_500, 7, 2)));

        mockMvc.perform(MockMvcRequestBuilders.get("/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect((status().isOk()))
                .andExpect(jsonPath("$.id", is(3)));

        verify(productRepository).findById(3);
    }


    @Test
    public void valid_get_buy_product() throws Exception {
        when(productRepository.findById(3))
                .thenReturn(java.util.Optional.of(new Product(3, "Monitor", 2_500, 7, 2)));
        mockMvc.perform(MockMvcRequestBuilders.get("/buy/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Thank you!! We are shipping our product to you soon.")));
        verify(productRepository).findById(3);
    }

    @Test
    public void valid_get_reservation_product_available() throws Exception {
        when(productRepository.findById(3))
                .thenReturn(java.util.Optional.of(new Product(3, "Monitor", 2_500, 7, 2)));

        mockMvc.perform(MockMvcRequestBuilders.get("/reservation/3")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Thank you!! You has reservation our product.")));

        verify(productRepository).findById(3);
    }

    @Test
    public void valid_get_reservation_product_no_left() throws Exception {
        when(productRepository.findById(6))
                .thenReturn(java.util.Optional.of(new Product(6, "Macbook Pro", 7_900, 7, 4)));

        mockMvc.perform(MockMvcRequestBuilders.get("/reservation/6")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Sorry!! We have no product left for reservation.")));

        verify(productRepository).findById(6);
    }

    @Test
    public void valid_get_reservation_product_not_found() throws Exception {
        when(productRepository.findById(7))
                .thenReturn(java.util.Optional.of(null));
        mockMvc.perform(MockMvcRequestBuilders.get("/reservation/7")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Your order not found!!")));
        verify(productRepository).findById(7);
    }

}
