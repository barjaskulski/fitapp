package sda.fitapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sda.fitapp.ENUM.TagsType;
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
    public MealEntity addMeal(@RequestBody MealRequest mealRequest) {
        return mealService.addMeal(mealRequest);
    }

    @GetMapping
    public List<MealEntity> getAllMeal() {
        return mealService.getAllMeal();
    }

    @GetMapping("/id/{id}")
    public MealEntity getMealById(@RequestParam long id) {
        return mealService.getMealById(id);
    }

    @GetMapping("/breakfast")
    public List<MealEntity> getMealBreakfast() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<TagEntity> tagEntityList = new ArrayList<>();
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));

        List<MealEntity> mealEntityList = new ArrayList<>();
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));

        return mealEntityList;
    }

    @GetMapping("/second_breakfast")
    public List<MealEntity> getMealSecondBreakfast() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<TagEntity> tagEntityList = new ArrayList<>();
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));

        List<MealEntity> mealEntityList = new ArrayList<>();
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));

        return mealEntityList;
    }

    @GetMapping("/dinner")
    public List<MealEntity> getMealDinner() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<TagEntity> tagEntityList = new ArrayList<>();
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));

        List<MealEntity> mealEntityList = new ArrayList<>();
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));

        return mealEntityList;
    }

    @GetMapping("/supper")
    public List<MealEntity> getMealSupper() {
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 1,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));
        wrapperIngredientToProportionList.add(new WrapperIngredientToProportion((long) 2,new IngredientEntity(1,"a",2,1,2,1,
                true,true,true),1.5 ));

        List<TagEntity> tagEntityList = new ArrayList<>();
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));
        tagEntityList.add(new TagEntity((long)1,"a", TagsType.MEAL));

        List<MealEntity> mealEntityList = new ArrayList<>();
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));
        mealEntityList.add(new MealEntity(1, "a","a",wrapperIngredientToProportionList, true,true,true,true, tagEntityList));

        return mealEntityList;
    }



}
