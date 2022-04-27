package com.practice.onlinemarket.serviceImpl;

import com.practice.onlinemarket.model.Product;

import java.util.List;

public interface ProductServiceImpl {
    List<Product> findAll();
    Product findById(Long id);
    List<Product> findByName(String name);
    List<Product> findByPrice(float price);
    void save(Product product);
    List<Product> saveAllProducts(List<Product> products);
    Product getProduct(Long id);
    void deleteById(Long id);
    Product updateProduct(Product product);
}
