package com.example.mission6.mission6fullapiunittest.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "tbl_product")
public class Product {

    @Id
    @Column(name = "  product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "product_name")
    private String productName;

    private int price;

    private int quantity;

    private int reservations;

    public Product() {
    }

    public Product(Integer id, @NotBlank String productName, int price, int quantity, int reservations) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReservations() {
        return reservations;
    }

    public void setReservations(int reservations) {
        this.reservations = reservations;
    }
}
