package com.example.food_integrator.service;

import com.example.food_integrator.model.Restaurant;
import com.example.food_integrator.model.SearchResultDto;

import java.math.BigDecimal;
import java.util.List;

public interface FoodService {
    //Метод для поиска ресторанов по названию блюда и цене

    List<SearchResultDto> search(String query, BigDecimal maxPrice);
}
