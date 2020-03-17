package com.example.client;

import com.example.model.Customer;
import com.example.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "products", url = "${microservices.product.url}")
public interface ProductClient {

    @GetMapping("/products/")
    List<Product> getAllProducts();

    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable("id") String id);
}
