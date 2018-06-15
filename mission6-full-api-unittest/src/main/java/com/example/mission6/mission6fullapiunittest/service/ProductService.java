package com.example.mission6.mission6fullapiunittest.service;

import com.example.mission6.mission6fullapiunittest.domain.Product;
import com.example.mission6.mission6fullapiunittest.domain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean checkAvailable(Product product) {
        return product.getQuantity() > product.getReservations() ? true : false;
    }

    public String reservation(Optional<Product> product) {
        if (product.isPresent()) {
            Product productAvailable = product.get();
            if (checkAvailable(productAvailable)) {
                productAvailable.setReservations(productAvailable.getReservations() + 1);
                productRepository.save(productAvailable);
                return "Thank you!! You has reservation our product.";
            } else
                return "Sorry!! We have no product left for reservation.";
        } else
            return "Your order not found!!";
    }


}
