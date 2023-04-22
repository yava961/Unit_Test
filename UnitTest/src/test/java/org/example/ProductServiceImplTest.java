package org.example;

import org.example.model.Product;
import org.example.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductServiceImplTest {
    private ProductServiceImpl productService;

    @BeforeEach
    public void setup() {
        productService = new ProductServiceImpl();
    }

    @Test
    public void testCalculatePriceWithoutPromo() {
        Product product = new Product('B', 4.25, 0, 0.0);
        int count = 2;
        double cost = productService.calculateProductPrice(product, count);
        Assertions.assertEquals(8.5, cost);
    }

    @Test
    public void testCalculatePriceWithPromo() {
        Product product = new Product('C', 1.0, 6, 5.0);
        int count = 6;
        double cost = productService.calculateProductPrice(product, count);
        Assertions.assertEquals(5.0, cost);
    }

    @Test
    public void testCalculateTotalCost() {
        String basket = "ABCDABA";
        double cost = productService.calculateTotalPrice(basket);
        Assertions.assertEquals(13.25, cost);
    }

}
