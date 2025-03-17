package com.example.order_service.restcontroller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.order_service.dto.OrderDto;
import com.example.order_service.service.IOrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/order")
public class OrderController {

    private final IOrderService service;


    @PostMapping("/registerOrder")
    public ResponseEntity<String> registerOrder(@RequestBody OrderDto orderDto) {
        var responseBody = service.registerOrder(orderDto);
        return new ResponseEntity<>(responseBody, HttpStatus.CREATED);
    }

    @GetMapping("findAllOrders")
    public ResponseEntity<List<OrderDto>> findAllOrders() {
        var responseBody = service.findAllOrders();
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @GetMapping("/findOrderById/{orderId}")
    public ResponseEntity<OrderDto> findOrderById(@PathVariable String orderId) {
        var orderDetails = service.findOrderById(orderId);
        return new ResponseEntity<OrderDto>(orderDetails, HttpStatus.OK);
    }

    @PutMapping("/updateOrder")
    public ResponseEntity<String> updateOrder(@RequestBody OrderDto orderDto){
        var updatedOrder = service.updateOrder(orderDto);
        return new ResponseEntity<String>(updatedOrder, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{orderId}")
    public ResponseEntity<String> deleteOrderById(@PathVariable String orderId){
        var message = service.deleteOrderById(orderId);
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllOrders")
    public ResponseEntity<String> deleteAllOrders(){
        var message = service.deleteAllOrders();
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @GetMapping("/findOrdersByOrderDate/{orderDate}")
    public ResponseEntity<List<OrderDto>> findOrderByOrderDate(@PathVariable LocalDateTime orderDate){
        var listOfOrders = service.findOrderByOrderDate(orderDate);
        return new ResponseEntity<List<OrderDto>>(listOfOrders, HttpStatus.OK);
    }

    @GetMapping("/findOrdersByOrderStatus/{orderStatus}")
    public ResponseEntity<List<OrderDto>> findOrderByOrderStatus(@PathVariable String orderStatus){
        var listOfOrders = service.findOrderByOrderStatus(orderStatus);
        return new ResponseEntity<List<OrderDto>>(listOfOrders, HttpStatus.OK);
    }

    @GetMapping("/findOrdersByPostalCode/{postalCode}")
    public ResponseEntity<List<OrderDto>> findOrderByPostalCode(@PathVariable String postalCode){
        var listOfOrders = service.findOrderByPostalCode(postalCode);
        return new ResponseEntity<List<OrderDto>>(listOfOrders, HttpStatus.OK);
    }


    @GetMapping("/findOrdersByEstimatedDeliveryDate/{estimatedDeliveryDate}")
    public ResponseEntity<List<OrderDto>> findOrderByEstimatedDeliveryDate(@PathVariable LocalDateTime estimatedDeliveryDate){
        var listOfOrders = service.findOrderByEstimatedDeliveryDate(estimatedDeliveryDate);
        return new ResponseEntity<List<OrderDto>>(listOfOrders, HttpStatus.OK);
    }


    @GetMapping("/findOrdersByCreatedAtBefore/{createdDate}")
    public ResponseEntity<List<OrderDto>> findOrderByCreatedAtBefore(@PathVariable LocalDateTime createdDate){
        var listOfOrders = service.findOrderByCreatedAtBefore(createdDate);
        return new ResponseEntity<List<OrderDto>>(listOfOrders, HttpStatus.OK);
    }


   

}
