package com.workintech.s19d1.services;

import com.workintech.s19d1.repository.FruitRepository;
import com.workintech.s19d1.entity.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> getByName(String name) {
        return fruitRepository.getByName(name);
    }

    @Override
    public Fruit findById(Long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isPresent()){
            return optionalFruit.get();
        } else {
            return null;
            //TODO exception
        }
    }

    @Override
    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit delete(Long id) {
        Optional<Fruit> optionalFruit = fruitRepository.findById(id);
        if(optionalFruit.isPresent()){
        fruitRepository.delete(optionalFruit.get());
        return optionalFruit.get();
        } else {
            //TODO exception
            return null;
        }
    }
}
