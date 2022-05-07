package com.practice.onlinemarket.controller;

import com.practice.onlinemarket.DTO.CustomerDTO;
import com.practice.onlinemarket.model.Customer;
import com.practice.onlinemarket.model.Product;
import com.practice.onlinemarket.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    public CustomerService customerService;

    @GetMapping("/customer/findAll")
    public List<Customer> getAllCustomer() {
        return customerService.findAll();
    }

    @PostMapping("/customer/save")
    public void saveOneCustomer(@RequestBody Customer customer) {
        customerService.saveOne(customer);
    }

    @PostMapping("/customer/saveAll")
    public void saveAllCustomer(@RequestBody List<Customer> customers) {
        customerService.saveAll(customers);
    }

    @GetMapping("/customer/findById/{id}")
    public Customer getProductById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @GetMapping("/customer/findCustomerDTO")
    public List<CustomerDTO> getAllCustomerDTO() {
        return customerService.findAllCustomer();
    }
    @GetMapping("/customer/findCustomerDTO/{id}")
    public CustomerDTO getCustomerDTO(@PathVariable Customer customer) {
        return customerService.findCustomer(customer);
    }
}
