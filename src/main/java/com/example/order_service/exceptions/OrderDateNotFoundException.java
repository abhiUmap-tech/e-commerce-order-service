package com.example.order_service.exceptions;

public class OrderDateNotFoundException extends RuntimeException{

    public OrderDateNotFoundException(String message){
        super(message);
    }

}
