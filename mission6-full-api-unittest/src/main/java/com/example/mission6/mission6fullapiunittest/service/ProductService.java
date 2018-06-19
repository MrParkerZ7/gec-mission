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

    public String transaction(Optional<Product> product, Status status) {

        if (product.isPresent()) {
            Product available = product.get();

            if (checkAvailable(available)) {

                if (status == Status.RESERVATION)
                    available.setReservations(available.getReservations() + 1);
                else if (status == Status.BUY)
                    available.setQuantity(available.getQuantity() - 1);

                productRepository.save(available);

                return "Thank you!! Your transaction complete!!";
            } else
                return "Sorry!! We have no product left for you.";
        } else
            return "Your order not found!!";
    }


}
