package com.example.mission2.mission2basicrestapi.model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsersRepository extends JpaRepository<Users, Integer> {
}
