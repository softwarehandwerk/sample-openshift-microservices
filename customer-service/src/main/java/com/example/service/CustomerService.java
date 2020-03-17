package com.example.service;

import com.example.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private List<Customer> customerList = List.of(
            Customer.builder().id("1").firstName("Marvin").lastName("Freiberger").build(),
            Customer.builder().id("2").firstName("Charles").lastName("Schmidt").build(),
            Customer.builder().id("3").firstName("Andy").lastName("Müller").build()
            ); // 2)

    public Customer findById(String id){
        return customerList.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst().orElse(Customer.builder().build());
    }

    public List<Customer> getAll(){
        return customerList;
    }

}
