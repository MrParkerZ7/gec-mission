package com.example.thelastcourse.mission7thelastcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private List pack = new ArrayList();

    @GetMapping
    public String home() {
        return "index";
    }

    @GetMapping("/add-product")
    public String addProduct() {
        return "/add-product/add-product";
    }

    @GetMapping("/list-product")
    public String newProduct() {
        return "/list-product/list-product";
    }
}
