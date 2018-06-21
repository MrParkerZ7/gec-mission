package com.example.mission4.database.migration.mission4databasemigration;

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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductRepository productRepository;

    @Test
    public void valid_get_all() throws Exception {
        when(productRepository.findAll()).thenReturn(
                new ArrayList<>(Arrays.asList(
                        new Product("Ipad", 1000, 7,0),
                        new Product("Pen", 17, 23,0),
                        new Product("Head Phone", 490, 12,0),
                        new Product("Monitor LED", 2700, 3,0),
                        new Product("Lan Cable", 150, 34,0),
                        new Product("Mouse Logitech", 3900, 2,0)
                ))
        );

        mockMvc.perform(get("/all")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(6)))
                .andExpect(jsonPath("$[0].productName", is("Ipad")))
                .andExpect(jsonPath("$[3].price", is(2700)))
                .andExpect(jsonPath("$[4].quantity", is(34)));

        verify(productRepository).findAll();
    }
}
