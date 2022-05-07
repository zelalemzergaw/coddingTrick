package com.practice.onlinemarket.serviceImpl;

import com.practice.onlinemarket.model.Product;

import java.util.List;

public interface ProductServiceImpl {
    List<Product> findAll();
    Product findById(long id);
    List<Product> findByName(String name);
    List<Product> findByPrice(float price);
    Product save(Product product);
    List<Product> saveAllProducts(List<Product> products);
    Product getProduct(long id);
    void deleteById(Long id);
    Product updateProduct(Product product);
}
