package com.example.order_service.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    // Basic Order Information
    @Id
    private String orderId;
    private String customerId;
    private LocalDateTime orderDate;
    private String orderStatus; // e.g., PENDING, COMPLETED, CANCELLED


    // Shipping Information
    private String shippingAddress;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private LocalDateTime estimatedDeliveryDate;

    // Product Information
    private List<String> productIds; // IDs of products in the order
    private BigDecimal shippingCost;

    // Timestamps
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
