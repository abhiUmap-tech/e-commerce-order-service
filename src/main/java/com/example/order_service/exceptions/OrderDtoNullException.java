package com.example.order_service.exceptions;

public class OrderDtoNullException extends RuntimeException{

    public OrderDtoNullException(String message){
        super(message);
    }

}
