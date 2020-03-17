package com.example.service;

import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private List<Product> productList = List.of(
      Product.builder().id("1").name("iPhone 11 pro").description("Pro Kameras. Pro Display. Pro Performance.").price("889").build(),
      Product.builder().id("2").name("Xiaomi mi 9").description("128GB Schwarz Dual SIM hat 6GB RAM und eine 48 MP").price("309").build(),
      Product.builder().id("3").name("16 MacBook Pro").description("Native Auflösung von 3072 x 1920 Pixeln bei 226 ppi").price("2.699").build()
    );

    public List<Product> getAll(){
        return productList;
    }

    public Product getById(String id){
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst().orElse(Product.builder().build());
    }

}
