package org.example.controller;

import org.example.models.Dish;
import org.example.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    @PostMapping
    public ResponseEntity<Dish> addDish(@RequestBody Dish dish) {
        return ResponseEntity.ok(dishService.addDish(dish));
    }

}
