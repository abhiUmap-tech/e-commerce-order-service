package com.example.order_service.configurations;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

    private int statusCode;

    private String message;

    private LocalDateTime timeStamp;
}
