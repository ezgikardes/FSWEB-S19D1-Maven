package com.workintech.s19d1.dto;

import com.workintech.s19d1.entity.Vegetable;

public record VegetableResponse(String message, Vegetable vegetable) {
}
