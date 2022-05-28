package com.practice.onlinemarket.service;

import com.practice.onlinemarket.exception.ApiRequestException;
import com.practice.onlinemarket.model.Product;
import com.practice.onlinemarket.ropository.ProductRepository;
import com.practice.onlinemarket.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements ProductServiceImpl {
    @Autowired
    public ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
    @Override
    public Product findById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }
    @Override
    public List<Product> findByPrice(float price) {
        return productRepository.findByPrice(price);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product getProduct(long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
          productRepository.deleteById(id);

    }
    @Override
    public Product updateProduct(Product product) {
        Product productEntity = productRepository.findById(product.getId()).orElse(null);
        return productEntity.toBuilder()
                .brand(product.getBrand())
                .madeIn(product.getMadeIn())
                .name(product.getName())
                .price(product.getPrice())
                .build();
    }

    public int computeVal(int input) {
        int result;
        try{
             result=input / 0;
        } catch(ArithmeticException arithmeticException){
            throw new ApiRequestException("Zero could not divided by ay number");
        }
        return result;
    }
}
