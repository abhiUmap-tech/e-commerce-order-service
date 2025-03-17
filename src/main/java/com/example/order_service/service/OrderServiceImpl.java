package com.example.order_service.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.example.order_service.dto.OrderDto;
import com.example.order_service.entity.Order;
import com.example.order_service.exceptions.EstimatedDeliveryDateNotFoundException;
import com.example.order_service.exceptions.OrderDateNotFoundException;
import com.example.order_service.exceptions.OrderDtoNullException;
import com.example.order_service.exceptions.OrderNotFoundException;
import com.example.order_service.exceptions.OrderStatusNotFoundException;
import com.example.order_service.exceptions.PostalCodeNotFoundException;
import com.example.order_service.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final OrderRepository repo;
    private final ModelMapper modelMapper;

    @Override
    public String registerOrder(OrderDto orderDto) {
        return Optional.ofNullable(orderDto)
                .map(dto -> {
                    // Convert the Dto to Order
                    var order = modelMapper.map(dto, Order.class);
                    // Save the converted Order to Repo
                    var savedOrder = repo.save(order);
                    // Convert the Order to Dto and return
                    modelMapper.map(savedOrder, OrderDto.class);
                    return "Order registered successfully with Id::" + savedOrder.getOrderId();
                })
                .orElseThrow(() -> new OrderDtoNullException("Order Dto cannot be null or empty"));

    }

    @Override
    public List<OrderDto> findAllOrders() {
        var listOfOrders = repo.findAll();
        return listOfOrders.stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDto findOrderById(String id) {
        var orderDetails = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order Not Found for the given Id::" + id));
        return modelMapper.map(orderDetails, OrderDto.class);

    }

    @Override
    public String updateOrder(OrderDto orderDto) {
        return Optional.ofNullable(orderDto)
                .map(dto -> {
                    // Convert the Dto to Order
                    var order = modelMapper.map(dto, Order.class);
                    // Save the updated Order
                    var updatedOrder = repo.save(order);
                    // Convert the Order to DTo
                    modelMapper.map(updatedOrder, OrderDto.class);
                    return "Order updated successfully with the id::" + updatedOrder.getOrderId();
                })
                .orElseThrow(() -> new OrderDtoNullException("Order Dto cannot be null or empty"));
    }

    @Override
    public String deleteOrderById(String id) {
        var orderDetails = repo.findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Order Not found for the given id::" + id));
        repo.deleteById(orderDetails.getOrderId());
        return "Order with the Id::" + id + " deleted successfully";
    }

    @Override
    public String deleteAllOrders() {
        repo.deleteAll();
        return "Deleted all Order successfully";
    }

    @Override
    public List<OrderDto> findOrderByOrderDate(LocalDateTime orderDate) {
        return Optional.of(repo.findByOrderDate(orderDate))
                // Filter to check if the list of orders is not empty
                .filter(order -> !order.isEmpty())
                // Throw a custom exception if no orders are found
                .orElseThrow(() -> new OrderDateNotFoundException("No orders found for the order date::" + orderDate))
                // Stream through the orders list
                .stream()
                // Map each Order entity to an OrderDto
                .map(order -> modelMapper.map(order, OrderDto.class))
                // Collect the mapped OrderDto objects into a list
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByOrderStatus(String orderStatus) {
        return Optional.of(repo.findByOrderStatus(orderStatus))
                .filter(order -> !order.isEmpty())
                .orElseThrow(() -> new OrderStatusNotFoundException("No Orders found for the Status::" + orderStatus))
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public List<OrderDto> findOrderByPostalCode(String postalCode) {
        return Optional.of(repo.findByPostalCode(postalCode))
                .filter(order -> !order.isEmpty())
                .orElseThrow(
                        () -> new PostalCodeNotFoundException("No orders found for the Postal Code::" + postalCode))
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByEstimatedDeliveryDate(LocalDateTime estimatedDeliveryDate) {
        return Optional.of(repo.findByEstimatedDeliveryDate(estimatedDeliveryDate))
                .filter(order -> !order.isEmpty())
                .orElseThrow(() -> new EstimatedDeliveryDateNotFoundException(
                        "No orders found for the given estimated delivery date::" + estimatedDeliveryDate))
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDto> findOrderByCreatedAtBefore(LocalDateTime localDateTime) {
        return Optional.of(repo.findByCreatedAtBefore(localDateTime))
                .filter(order -> !order.isEmpty())
                .orElseThrow(
                        () -> new OrderNotFoundException("No orders were createdBefore the date::" + localDateTime))
                .stream()
                .map(order -> modelMapper.map(order, OrderDto.class))
                .collect(Collectors.toList());
    }

}
