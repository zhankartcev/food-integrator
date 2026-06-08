package com.example.food_integrator.service;

import com.example.food_integrator.model.Dish;
import com.example.food_integrator.model.Restaurant;
import com.example.food_integrator.model.SearchResultDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImpl implements FoodService {
    private List<Restaurant> database = new ArrayList<>();

    public FoodServiceImpl() {
        database.add(new Restaurant("Pizza Hub", 30, List.of(
                new Dish("Пицца", new BigDecimal("500")),
                new Dish("Бургер", new BigDecimal("300"))
        )));
        database.add(new Restaurant("Sushi Master", 45, List.of(
                new Dish("Пицца", new BigDecimal("700")),
                new Dish("Суши", new BigDecimal("600"))

        )));
    }

    @Override
    public List<SearchResultDto> search(String query, BigDecimal maxPrice) {
        List<SearchResultDto> results = new ArrayList<>();

        for (Restaurant res : database) {
            for (Dish dish : res.getMenu()) {
                // Проверяем: совпадает ли название блюда И цена ниже максимальной
                if (dish.getName().equalsIgnoreCase(query) && dish.getPrice().compareTo(maxPrice) <= 0) {
                    results.add(new SearchResultDto(
                            res.getName(),
                            res.getDeliveryTime(),
                            dish.getName(),
                            dish.getPrice()
                    ));
                }
            }
        }
        // Сортируем по цене: сначала самые выгодные варианты!
        results.sort((a, b) -> a.getDishPrice().compareTo(b.getDishPrice()));
        return results;
    }

}
