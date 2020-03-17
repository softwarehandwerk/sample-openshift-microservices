package com.example.service;

import com.example.client.CustomerClient;
import com.example.client.ProductClient;
import com.example.model.Customer;
import com.example.model.Order;
import com.example.model.OrderSummary;
import com.example.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final CustomerClient customerClient;
    private final ProductClient productClient;

    private List<Order> orderList = List.of(
            Order.builder().id("1").status("STORNIERT").customerId("2").productIdList(List.of("1","2","3")).build(),
            Order.builder().id("2").status("VERSENDET").customerId("3").productIdList(List.of("2")).build(),
            Order.builder().id("3").status("GELIEFERT").customerId("1").productIdList(List.of("1","1","1","1")).build()
    );

    public OrderService(CustomerClient customerClient, ProductClient productClient) {
        this.customerClient = customerClient;
        this.productClient = productClient;
    }

    public List<Order> getAll(){
        return orderList;
    }

    public OrderSummary getById(String id){
        return orderList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .map(order -> {
                    Customer customer = customerClient.getCustomerById(order.getCustomerId());

                    List<Product> productList = order.getProductIdList().stream()
                            .map(productClient::getProductById)
                            .collect(Collectors.toList());

                    return OrderSummary.builder()
                            .id(order.getId())
                            .customer(customer)
                            .productList(productList)
                            .status(order.getStatus())
                            .build();
                })
                .orElse(OrderSummary.builder().build());
    }

}
