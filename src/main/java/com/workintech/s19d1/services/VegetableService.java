package com.workintech.s19d1.services;

import com.workintech.s19d1.entity.Vegetable;
import java.util.List;

public interface VegetableService {
    List<Vegetable> findAll();

    Vegetable save(Vegetable vegetable);

    Vegetable findById(Long id);

    List<Vegetable> getByPriceDesc();

    List<Vegetable> getByPriceAsc();

    List<Vegetable> getByName(String name);

    Vegetable delete(Long id);
}
