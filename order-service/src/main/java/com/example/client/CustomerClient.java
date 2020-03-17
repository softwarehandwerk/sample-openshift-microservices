package com.example.client;

import com.example.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "customers", url = "${microservices.customer.url}")
public interface CustomerClient {

    @GetMapping("/customers/")
    List<Customer> getAllCustomers();

    @GetMapping("/customers/{id}")
    Customer getCustomerById(@PathVariable("id") String id);
}
