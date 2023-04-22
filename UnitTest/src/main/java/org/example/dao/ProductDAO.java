package org.example.dao;

import org.example.model.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO {
    private Map<Character, Product> productMap;

    public ProductDAO() {
        productMap = new HashMap<Character, Product>();
        productMap.put('A', new Product('A', 1.25, 3, 3.0));
        productMap.put('B', new Product('B', 4.25, 0, 0.0));
        productMap.put('C', new Product('C', 1.0, 6, 5.0));
        productMap.put('D', new Product('D', 0.75, 0, 0.0));
    }

    public Product getProduct(char code) {
        return productMap.get(code);
    }
}
