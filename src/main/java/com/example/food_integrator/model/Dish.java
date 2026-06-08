package com.example.food_integrator.model;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor

public class Dish {
    private String name;
    private BigDecimal price;
}
