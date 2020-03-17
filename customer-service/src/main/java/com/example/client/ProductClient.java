package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "products", url = "${microservices.product.url}")
public interface ProductClient {

    @GetMapping("/products/all")
    List<String> getAllProducts();
}
