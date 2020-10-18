package sda.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.dto.MealRequest;
import sda.fitapp.entity.*;
import sda.fitapp.repository.MealRepositories;
import sda.fitapp.service.MealService;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    public List<Meal> getAllMeal() {
        return mealService.getAllMeal();
    }

    @GetMapping("/id/{id}")
    public Meal getMealById(@RequestParam long id) {
        return mealService.getMealById(id);
    }

    @GetMapping("/breakfast")
    public List<Meal> getMealBreakfast() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));

        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));

        return mealList;
    }

    @GetMapping("/second_breakfast")
    public List<Meal> getMealSecondBreakfast() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));

        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));

        return mealList;
    }

    @GetMapping("/dinner")
    public List<Meal> getMealDinner() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));

        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));

        return mealList;
    }

    @GetMapping("/supper")
    public List<Meal> getMealSupper() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new Ingredient(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<Tag> tagList = new ArrayList<>();
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));
        tagList.add(new Tag((long)1,"a", TagsType.MEAL));

        List<Meal> mealList = new ArrayList<>();
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));
        mealList.add(new Meal(1, "a","a",wrapperIngredientToProportionList, true,true,true,true,tagList));

        return mealList;
    }

}
