package com.example.order_service.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {

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
