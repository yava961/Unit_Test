package com.example.service.impl;

import com.example.dao.ProductDAO;
import com.example.model.Product;
import com.example.service.ProductService;

import java.util.HashMap;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private ProductDAO productDAO;

    public ProductServiceImpl() {
        productDAO = new ProductDAO();
    }

    @Override
    public Map<Character, Integer> calculateProductCount(String cart) {
        Map<Character, Integer> productCounts = new HashMap<>();
        for (char productCode : cart.toCharArray()) {
            productCounts.put(productCode, productCounts.getOrDefault(productCode, 0) + 1);
        }
        return productCounts;
    }

    @Override
    public double calculateProductPrice(Product product, int quantity) {
        if (product.getPromoQuantity() > 0 && quantity >= product.getPromoQuantity()) {
            int promoCount = quantity / product.getPromoQuantity();
            int regularCount = quantity % product.getPromoQuantity();
            return promoCount * product.getPromoPrice() + regularCount * product.getPrice();
        } else {
            return quantity * product.getPrice();
        }
    }


    @Override
    public double calculateTotalPrice(String cart) {
        Map<Character, Integer> productCount = calculateProductCount(cart);

        double totalCost = 0.0;
        for (Map.Entry<Character, Integer> entry : productCount.entrySet()) {
            Product product = productDAO.getProduct(entry.getKey());
            totalCost += calculateProductPrice(product, entry.getValue());
        }
        return totalCost;
    }
}
