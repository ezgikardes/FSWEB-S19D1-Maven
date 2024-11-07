package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.FruitResponse;
import com.workintech.s19d1.dto.VegetableResponse;
import com.workintech.s19d1.entity.Vegetable;
import com.workintech.s19d1.services.VegetableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<VegetableResponse> findById(@PathVariable Long id){
        Vegetable vegetable = vegetableService.findById(id);
        return ResponseEntity.ok(new VegetableResponse("Vegetable found", vegetable));
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
    public ResponseEntity<VegetableResponse> save(@RequestBody Vegetable vegetable){
        Vegetable savedVegetable = vegetableService.save(vegetable);
        return ResponseEntity.ok(new VegetableResponse("Vegetable successfully saved", savedVegetable));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VegetableResponse> delete(@PathVariable Long id){
        Vegetable vegetable = vegetableService.delete(id);
        return ResponseEntity.ok(new VegetableResponse("Vegetable successfully deleted", vegetable));
    }



}
