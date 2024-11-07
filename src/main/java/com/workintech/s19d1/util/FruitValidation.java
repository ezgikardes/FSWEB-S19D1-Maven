package com.workintech.s19d1.util;

import com.workintech.s19d1.exceptions.FruitException;
import org.springframework.http.HttpStatus;

public class FruitValidation {

    public static void validateId(Long id){
        if(id == null || id <= 0){
            throw new FruitException("Invalid ID: ID must be a positive number", HttpStatus.BAD_REQUEST);
        }
    }
}
