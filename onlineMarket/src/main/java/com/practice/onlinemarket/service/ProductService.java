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
    public Product findById(Long id) {
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
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> saveAllProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);

    }

    @Override
    public Product updateProduct(Product product) {
        Product productEntity = productRepository.findById(product.getId()).orElse(null);
        productEntity.setBrand(product.getBrand());
        productEntity.setMadeIn(product.getMadeIn());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        return productRepository.save(productEntity);
    }

    public int computeVal(int input) {
        int result;
        try{
             result=input / 0;
        } catch(ArithmeticException arithmeticException){
//            throw new ArithmeticException("Zero could not devided by ay number");
            throw new ApiRequestException("Zero could not devided by ay number");
        }
        return result;
    }
}
