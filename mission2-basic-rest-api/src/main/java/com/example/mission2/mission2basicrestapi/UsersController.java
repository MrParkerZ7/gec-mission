package com.example.mission2.mission2basicrestapi;

import com.example.mission2.mission2basicrestapi.Users;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UsersController {

    @GetMapping("/contact")
    Users contact() {
        Users users = new Users("Natthapong Noosing", "721 Labpraw 36, Chankhaseam, Chatuchak, Bangkok 10900");
        return users;
    }

    @GetMapping("/contacts")
    List<Users> contacts() {
        List<Users> users = new ArrayList<>();
        users.add(new Users("Macro", "USA some where..."));
        users.add(new Users("Maria", "China some where..."));
        users.add(new Users("Bruno", "Law some where..."));
        return users;
    }


}
