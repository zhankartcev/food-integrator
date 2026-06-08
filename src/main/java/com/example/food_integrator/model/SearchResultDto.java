package com.example.food_integrator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class SearchResultDto {

    private String restaurantName;
    private int deliveryTime;
    private String dishName;
    private BigDecimal dishPrice;


}
