package com.example.thelastcourse.mission7thelastcourse.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UiController.class)
public class UiControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void request_home_page() throws Exception {
        mvc.perform(get("/")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @Test
    public void request_list_product_component() throws Exception {
        mvc.perform(get("/list-product")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

    @Test
    public void request_add_product_component() throws Exception {
        mvc.perform(get("/add-product")
                .contentType(MediaType.TEXT_HTML))
                .andExpect(status().isOk());
    }

}