package com.example.order_service.exceptions;

public class EstimatedDeliveryDateNotFoundException extends RuntimeException{

    public EstimatedDeliveryDateNotFoundException(String message){
        super(message);
    }

}
