package com.example.food_integrator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor

public class Restaurant {
    private String name;
    private int deliveryTime; //min
    private List<Dish> menu;


}
