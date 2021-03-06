package com.example.thelastcourse.mission7thelastcourse.controller;

import com.example.thelastcourse.mission7thelastcourse.entity.Product;
import com.example.thelastcourse.mission7thelastcourse.entity.ProductRepository;
import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductsController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void get_product() throws Exception {
        given(productRepository.findById(3)).willReturn(
                java.util.Optional.of(new Product(3, "Cola", 12, 50)));

        mvc.perform(get("/product/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(3)))
                .andExpect(jsonPath("$.name", is("Cola")))
                .andExpect(jsonPath("$.price", is(12)))
                .andExpect(jsonPath("$.quantity", is(50)));
    }

    @Test
    public void get_product_but_not_found() throws Exception {
        given(productRepository.findById(3)).willReturn(
                java.util.Optional.empty());

        mvc.perform(get("/product/3").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    public void get_product_all() throws Exception {
        given(productRepository.findAll()).willReturn(
                new ArrayList<>(Arrays.asList(
                        new Product(1, "Pen", 5, 50),
                        new Product(2, "Paper", 12, 2000),
                        new Product(3, "Book", 59, 17))));

        mvc.perform(get("/product").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[2].name", is("Book")))
                .andExpect(jsonPath("$[2].price", is(59)))
                .andExpect(jsonPath("$[2].quantity", is(17)));
    }

    @Test
    public void post_product_successful() throws Exception {
        String product = "{\"id\":1,\"name\":\"Pen\",\"price\":5,\"quantity\":170}";
        given(productRepository.existsById(1)).willReturn(false);

        mvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON).content(product))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Save Successfully")));
    }

    @Test
    public void post_product_failure() throws Exception {
        String product = "{\"id\":1,\"name\":\"Pen\",\"price\":5,\"quantity\":170}";
        given(productRepository.existsById(1)).willReturn(true);

        mvc.perform(post("/product").contentType(MediaType.APPLICATION_JSON).content(product))
                .andDo(print())
                .andExpect(status().isNotAcceptable())
                .andExpect(jsonPath("$", is("ID Duplicated")));
    }

    @Test
    public void put_product_successful() throws Exception {
        String product = "{\"id\":1,\"name\":\"Pen\",\"price\":5,\"quantity\":170}";
        given(productRepository.existsById(1)).willReturn(true);

        mvc.perform(put("/product").contentType(MediaType.APPLICATION_JSON).content(product))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", is("Update Successfully")));
    }

    @Test
    public void put_product_failure() throws Exception {
        String product = "{\"id\":1,\"name\":\"Pen\",\"price\":5,\"quantity\":170}";
        given(productRepository.existsById(1)).willReturn(false);

        mvc.perform(put("/product").contentType(MediaType.APPLICATION_JSON).content(product))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$", is("Product Not Found")));
    }

}
