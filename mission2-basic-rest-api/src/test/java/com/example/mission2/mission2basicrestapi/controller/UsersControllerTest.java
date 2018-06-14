package com.example.mission2.mission2basicrestapi.controller;

import com.example.mission2.mission2basicrestapi.model.Users;
import com.example.mission2.mission2basicrestapi.service.ApiInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(UsersController.class)
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Users users;

    @MockBean
    private ApiInfoService apiInfoService;


    @Test
    public void valid_get_contact_one() throws Exception {
        mockMvc.perform(get("/contactOne")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("Natthapong Noosing")));
    }

    @Test
    public void valid_get_contacts() throws Exception {
        mockMvc.perform(get("/contacts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("Macro")));
    }

    @Test
    public void valid_mock_test_users() throws Exception {
        // This is mock dummy which use for dummy ApiInfoService to test UsersController
        given(this.apiInfoService.getApiInfo()).willReturn("Promsawat Pitakmetakul Thailand 10400");
        this.mockMvc.perform(get("/contact").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("Promsawat Pitakmetakul Thailand 10400"));
    }

}


