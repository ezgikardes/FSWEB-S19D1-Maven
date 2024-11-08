package com.workintech.s19d1.services;

import com.workintech.s19d1.entity.Vegetable;
import com.workintech.s19d1.exceptions.VegetableException;
import com.workintech.s19d1.repository.VegetableRepository;
import com.workintech.s19d1.util.VegetableValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> findAll() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findById(Long id) {
        VegetableValidation.validateId(id);
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if (optionalVegetable.isPresent()){
            return optionalVegetable.get();
        } else {
            throw new VegetableException("Fruit not found", HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Vegetable> getByName(String name) {
        return vegetableRepository.getByName(name);
    }

    @Override
    public List<Vegetable> getByPriceAsc() {
        return vegetableRepository.getByPriceAsc();
    }

    @Override
    public List<Vegetable> getByPriceDesc() {
        return vegetableRepository.getByPriceDesc();
    }

    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable delete(Long id) {
        VegetableValidation.validateId(id);
        Optional<Vegetable> optionalVegetable = vegetableRepository.findById(id);
        if(optionalVegetable.isPresent()){
            vegetableRepository.delete(optionalVegetable.get());
            return optionalVegetable.get();
        } else {
            throw new VegetableException("Vegetable not found", HttpStatus.NOT_FOUND);
        }
    }
}
