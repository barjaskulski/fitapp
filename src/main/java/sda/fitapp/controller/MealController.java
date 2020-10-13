package sda.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.entity.Meal;
import sda.fitapp.repository.MealRepositories;

@RestController
@RequestMapping("/api/meal")
public class MealController {
    MealRepositories mealRepositories;

    @Autowired
    public MealController(MealRepositories mealRepositories) {
        this.mealRepositories = mealRepositories;
    }

    @PostMapping()
    public Meal addMeal(@RequestBody Meal meal) {
        return mealRepositories.save(meal);
    }

}
