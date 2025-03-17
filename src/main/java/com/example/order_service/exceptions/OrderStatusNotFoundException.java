package com.example.order_service.exceptions;

public class OrderStatusNotFoundException extends RuntimeException{

    public OrderStatusNotFoundException(String message){
        super(message);
    }

}
