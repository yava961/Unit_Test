package org.example.service;


import org.example.model.Product;

import java.util.Map;

public interface ProductService {
    Map<Character, Integer> calculateProductCount(String cart);

    double calculateProductPrice(Product product, int quantity);

    double calculateTotalPrice(String cart);
}
