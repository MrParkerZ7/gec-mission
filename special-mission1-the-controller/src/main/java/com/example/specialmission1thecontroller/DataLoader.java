package com.example.specialmission1thecontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("Park", 18),
                new User("Fark", 74),
                new User("Sark", 82)
        ));
        userRepository.saveAll(users);
    }
}
