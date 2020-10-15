package sda.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.dto.MealRequest;
import sda.fitapp.entity.Meal;
import sda.fitapp.repository.MealRepositories;
import sda.fitapp.services.MealService;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    MealRepositories mealRepositories;
    MealService mealService;

    @Autowired
    public MealController(MealRepositories mealRepositories, MealService mealService) {
        this.mealRepositories = mealRepositories;
        this.mealService = mealService;
    }

    @PostMapping
    public Meal addMeal(@RequestBody MealRequest mealRequest) {
        return mealService.addMeal(mealRequest);
    }

}
