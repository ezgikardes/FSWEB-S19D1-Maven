package com.workintech.s19d1.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<FruitErrorResponse> handleException(FruitException fruitException){
        FruitErrorResponse errorResponse = new FruitErrorResponse(fruitException.getMessage());
        return new ResponseEntity<>(errorResponse, fruitException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity<VegetableErrorResponse> handleException(VegetableException vegetableException){
        VegetableErrorResponse errorResponse = new VegetableErrorResponse(vegetableException.getMessage());
        return new ResponseEntity<>(errorResponse, vegetableException.getStatus());
    }

}
