package com.practice.onlinemarket.serviceImpl;

import com.practice.onlinemarket.DTO.CustomerDTO;
import com.practice.onlinemarket.model.Customer;

import java.util.List;

public interface CustomerServiceImpl {
    List<Customer> findAll();
    List<Customer> saveAll(List<Customer> customers);
    Customer findById(Long id);
    Customer saveOne(Customer customer);
    List<CustomerDTO> findAllCustomer();
    CustomerDTO findCustomer(Customer customer);

}
