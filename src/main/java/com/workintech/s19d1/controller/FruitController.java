package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.FruitResponse;
import com.workintech.s19d1.entity.Fruit;
import com.workintech.s19d1.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FruitResponse> getById(@PathVariable Long id){
        Fruit fruit = fruitService.findById(id);
        return ResponseEntity.ok(new FruitResponse("Friut found", fruit));
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
    public ResponseEntity<FruitResponse> save(@RequestBody Fruit fruit){
        Fruit savedFruit = fruitService.save(fruit);
        return ResponseEntity.ok(new FruitResponse("Fruit successfully saved", savedFruit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FruitResponse> delete(@PathVariable Long id){
        Fruit fruit = fruitService.delete(id);
        return ResponseEntity.ok(new FruitResponse("Fruit successfully deleted", fruit));
    }
}
