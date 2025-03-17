package com.example.order_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.order_service.entity.Order;
import java.util.List;
import java.time.LocalDateTime;


public interface OrderRepository extends MongoRepository<Order, String>{

    List<Order> findByOrderDate(LocalDateTime orderDate);

    List<Order> findByOrderStatus(String orderStatus);

    List<Order> findByPostalCode(String postalCode);

    List<Order> findByEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate);

    //Find all orders created before a specific time
    List<Order> findByCreatedAtBefore(LocalDateTime localDateTime);


}

