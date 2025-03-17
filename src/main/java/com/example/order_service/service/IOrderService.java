package com.example.order_service.service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.order_service.dto.OrderDto;

public interface IOrderService {

    String registerOrder(OrderDto orderDto);

    List<OrderDto> findAllOrders();

    OrderDto findOrderById(String id);

    String updateOrder(OrderDto orderDto);

    String deleteOrderById(String id);
    
    String deleteAllOrders();

     List<OrderDto> findOrderByOrderDate(LocalDateTime orderDate);

    List<OrderDto> findOrderByOrderStatus(String orderStatus);

    List<OrderDto> findOrderByPostalCode(String postalCode);

    List<OrderDto> findOrderByEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate);

    //Find all orders created before a specific time
    List<OrderDto> findOrderByCreatedAtBefore(LocalDateTime localDateTime);



}
