package com.workintech.s19d1.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class FruitException extends RuntimeException{
    private HttpStatus status;

    public FruitException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
