package com.practice.onlinemarket.service;

import com.practice.onlinemarket.DTO.CustomerDTO;
import com.practice.onlinemarket.model.Customer;
import com.practice.onlinemarket.ropository.CustomerRepository;
import com.practice.onlinemarket.serviceImpl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements CustomerServiceImpl {
    @Autowired
    public CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> saveAll(List<Customer> customers) {
        return customerRepository.saveAll(customers);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public Customer saveOne(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<CustomerDTO> findAllCustomer() {

        return customerRepository.findAll()
                .stream().map(this::findCustomer)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO findCustomer(Customer customer) {
        return CustomerDTO.builder()
                .id(customer.getCustomerId())
                .age(customer.getAge())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .brand(customer.getProduct().getBrand())
                .madeIn(customer.getProduct().getMadeIn())
                .name(customer.getProduct().getName())
                .manufacturedDate(customer.getProduct().getManufacturedDate())
                .price(customer.getProduct().getPrice()).build();
    }
}
