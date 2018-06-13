package com.example.mission2.mission2basicrestapi;


import com.sun.corba.se.spi.ior.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface UsersRepository extends JpaRepository<Users, ObjectId> {
}
