package com.example.food_integrator.controller;


import com.example.food_integrator.service.FoodService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class FoodController {

    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping("/")
    public String index(@RequestParam(required = false) String query,
                        @RequestParam(required = false) BigDecimal maxPrice,
                        Model model) {
        // Если пользователь что-то ввел — ищем, если нет — отдаем пустой список
        if (query != null && maxPrice != null) {
            model.addAttribute("results", foodService.search(query, maxPrice));

        }
        return "index";



    }
}
