package com.example.order_service.exceptions;

public class PostalCodeNotFoundException extends RuntimeException{

    public PostalCodeNotFoundException(String message){
        super(message);
    }

}
