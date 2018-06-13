package com.example.mission2.mission2basicrestapi;

import com.sun.corba.se.spi.ior.ObjectId;
import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String address;

    public Integer getId() {
        return id;
    }

    public Users(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Users() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
