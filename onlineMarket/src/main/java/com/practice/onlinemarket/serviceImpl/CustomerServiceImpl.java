package com.practice.onlinemarket.serviceImpl;

import com.practice.onlinemarket.model.Customer;

import java.util.List;

public interface CustomerServiceImpl {
    List<Customer> findAll();
    Customer findById(Long id);
}
