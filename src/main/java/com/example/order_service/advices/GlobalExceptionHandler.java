package com.example.order_service.advices;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.order_service.configurations.ErrorDetails;
import com.example.order_service.exceptions.EstimatedDeliveryDateNotFoundException;
import com.example.order_service.exceptions.OrderDateNotFoundException;
import com.example.order_service.exceptions.OrderDtoNullException;
import com.example.order_service.exceptions.OrderNotFoundException;
import com.example.order_service.exceptions.PostalCodeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EstimatedDeliveryDateNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleEstimatedDeliveryDateNotFoundException(
            EstimatedDeliveryDateNotFoundException estimatedDeliveryDateNotFoundException) {
        var errorDetails = new ErrorDetails(404, estimatedDeliveryDateNotFoundException.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderDateNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleOrderDateNotFoundException(
            OrderDateNotFoundException orderDateNotFoundException) {
        var errorDetails = new ErrorDetails(404, orderDateNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderDtoNullException.class)
    public ResponseEntity<ErrorDetails> handleOrderDtoNullException(OrderDtoNullException orderDtoNullException) {
        var errorDetails = new ErrorDetails(404, orderDtoNullException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleOrderNotFoundException(OrderNotFoundException orderNotFoundException) {
        var errorDetails = new ErrorDetails(404, orderNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PostalCodeNotFoundException.class)
    public ResponseEntity<ErrorDetails> handlePostalCodeNotFoundException(
            PostalCodeNotFoundException postalCodeNotFoundException) {
        var errorDetails = new ErrorDetails(404, postalCodeNotFoundException.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleGlobalException(Exception exception) {
        var errorDetails = new ErrorDetails(404, exception.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

}
