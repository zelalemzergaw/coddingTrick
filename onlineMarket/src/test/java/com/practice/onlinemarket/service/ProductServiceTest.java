package com.practice.onlinemarket.service;

import com.practice.onlinemarket.controller.ProductController;
import com.practice.onlinemarket.ropository.ProductRepository;
import com.practice.onlinemarket.util.Utility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceTest {
    ProductController productController = new ProductController();
    Utility utility = new Utility();

    @Autowired
    private ProductService productService;
    @MockBean
    private ProductRepository productRepository;

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByName() {
    }

    @Test
    void findByPrice() {
    }

    @Test
    void save() {
    }

    @Test
    void saveAllProducts() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void updateProduct() {
    }

    @Test
    void computeVal() {
    }
}