package com.project.ecplatform.service;

import com.project.ecplatform.model.Dish;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class KitchenService {

    private List<Dish> menu = Arrays.asList(
            new Dish("Indomie"),
            new Dish("Rice"),
            new Dish("Spaghetti")
    );

    private Random picker = new Random();


    public List<Dish> getDishes(){
        return Arrays.asList(randomDish());
    }

    private Dish randomDish(){
        return this.menu.get(picker.nextInt(3));
    }

}
