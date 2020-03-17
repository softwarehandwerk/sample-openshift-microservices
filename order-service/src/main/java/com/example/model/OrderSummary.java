package com.example.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OrderSummary {
    private String id;
    private String status;
    private Customer customer;
    private List<Product> productList;
}
