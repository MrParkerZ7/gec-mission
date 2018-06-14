package com.example.mission2.mission2basicrestapi.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Users> users = new ArrayList<>();
        users.add(new Users("Macro", "USA some where..."));
        users.add(new Users("Maria", "China some where..."));
        users.add(new Users("Bruno", "Law some where..."));
        usersRepository.saveAll(users);
    }
}
