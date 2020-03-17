package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public List<Customer> getAll(){
        return customerService.getAll();
    }


    @GetMapping("/{id}")
    public Customer findById(@PathVariable String id){

        Customer customer = customerService.findById(id);
        customer.setPodInfo(System.getenv("HOSTNAME")); // 3)
        return customer;
    }

}
