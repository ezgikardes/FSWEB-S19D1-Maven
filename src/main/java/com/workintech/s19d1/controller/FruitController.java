package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Fruit;
import com.workintech.s19d1.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {

    FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> findAll(){
        return fruitService.findAll();
    }

    @GetMapping("/{id}")
    public Fruit getById(@PathVariable Long id){
        return fruitService.findById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> getByPriceDesc(){
        return fruitService.getByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Fruit> getByPriceAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/name/{name}")
    public List<Fruit> getByName(@PathVariable String name){
        return fruitService.getByName(name);
    }

    @PostMapping
    public Fruit save(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@PathVariable Long id){
        return fruitService.delete(id);
    }
}
