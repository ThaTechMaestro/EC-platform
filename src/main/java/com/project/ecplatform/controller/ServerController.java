package com.project.ecplatform.controller;

import com.project.ecplatform.model.Dish;
import com.project.ecplatform.service.KitchenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ServerController {

    private final KitchenService kitchen;

    public ServerController(KitchenService kitchen){

        this.kitchen = kitchen;

    }

    @GetMapping("/server")
    public List<Dish> serveDishes(){
        return this.kitchen.getDishes();
    }

    @GetMapping("/served-dishes")
    public List<Dish> deliverDishes(){
        return this.kitchen.getDishes().stream()
                .map(dish -> Dish.deliver(dish))
                .collect(Collectors.toList());
    }
}
