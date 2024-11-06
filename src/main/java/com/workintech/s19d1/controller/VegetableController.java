package com.workintech.s19d1.controller;

import com.workintech.s19d1.entity.Vegetable;
import com.workintech.s19d1.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/vegetable")
public class VegetableController {

    VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.findAll();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@PathVariable Long id){
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> getByPriceDesc(){
        return vegetableService.getByPriceDesc();
    }

    @GetMapping("/asc")
    public List<Vegetable> getByPriceAsc(){
        return vegetableService.getByPriceAsc();
    }

    @GetMapping("/name/{name}")
    public List<Vegetable> getByName(@PathVariable String name){
        return vegetableService.getByName(name);
    }

    @PostMapping
    public Vegetable save(@RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@PathVariable Long id){
        return vegetableService.delete(id);
    }



}
