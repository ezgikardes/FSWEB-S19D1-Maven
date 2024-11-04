package com.workintech.s19d1.services;

import com.workintech.s19d1.entity.Fruit;

import java.util.List;

public interface FruitService {

    List<Fruit> findAll();

    Fruit save(Fruit fruit);

    Fruit findById(Long id);

    List<Fruit> getByPriceDesc();

    List<Fruit> getByPriceAsc();

    List<Fruit> getByName(String name);

    Fruit delete(Long id);

}
