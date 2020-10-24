package sda.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.entity.IngredientEntity;
import sda.fitapp.service.IngredientService;

import java.util.List;

@RestController
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping("/ingredient")
    public IngredientEntity addIngredient(@RequestBody IngredientEntity ingredientEntity) {
        return ingredientService.addIngredient(ingredientEntity);
    }

    @GetMapping("/ingredient/{id}")
    public IngredientEntity getIngredient(@PathVariable Long id){
        return ingredientService.getIngredientById(id);
    }

    @GetMapping("/ingredient")
    public List<IngredientEntity> getAllIngredients(){
        return ingredientService.getAllIngredients();
    }

    @DeleteMapping("/ingredient/{id}")
    public void removeIngredient(@PathVariable Long id){
        ingredientService.removeIngredientById(id);
    }

}
