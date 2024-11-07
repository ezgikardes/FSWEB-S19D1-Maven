package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Fruit;

public record FruitResponse(String message, Fruit fruit) {
}
