package com.example.model;

import jdk.jfr.DataAmount;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Order {
    private String id;
    private String status;
    private String customerId;
    private List<String> productIdList;
}
