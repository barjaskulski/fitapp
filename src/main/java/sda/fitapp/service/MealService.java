package sda.fitapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sda.fitapp.dto.IngredientProportion;
import sda.fitapp.entity.Meal;
import sda.fitapp.dto.MealRequest;
import sda.fitapp.entity.WrapperIngredientToProportion;
import sda.fitapp.repository.JpaIngredientRepository;
import sda.fitapp.repository.MealRepositories;
import sda.fitapp.repository.WrapperIngredientProportionRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class MealService {
    MealRepositories mealRepositories;
    WrapperIngredientProportionRepository wrapperIngredientProportionRepository;
    IngredientService ingredientService;

    @Autowired
    public MealService(MealRepositories mealRepositories,
                       WrapperIngredientProportionRepository wrapperIngredientProportionRepository,
                       IngredientService ingredientService) {
        this.mealRepositories = mealRepositories;
        this.wrapperIngredientProportionRepository = wrapperIngredientProportionRepository;
        this.ingredientService = ingredientService;
    }

    public Meal addMeal(@RequestBody MealRequest meal) {
        List<IngredientProportion> ingredientProportionList = meal.getIngredientWithProportions();
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        for (IngredientProportion el : ingredientProportionList) {
            WrapperIngredientToProportion wrapperEntity = new WrapperIngredientToProportion();
            wrapperEntity.setIngredient(ingredientService.getIngredientById(el.getIngredientId()));
            wrapperEntity.setProportion(el.getProportion());
            wrapperIngredientProportionRepository.save(wrapperEntity);
            wrapperIngredientToProportionList.add(wrapperEntity);
        }

        Meal mealEntity = new Meal();
        mealEntity.setWrapperIngredientToProportionList(wrapperIngredientToProportionList);
        mealEntity.setGLUTENFREE(meal.isGLUTENFREE());
        mealEntity.setName(meal.getName());
        mealEntity.setLowIg(meal.isLowIg());
        mealEntity.setVegan(meal.isVegan());
        mealEntity.setVegetarian(meal.isVegetarian());
        mealEntity.setRecepture(meal.getRecipe());

        return mealRepositories.save(mealEntity);
    }

    public List<Meal> getAllMeal() {
        return mealRepositories.findAll();
    }

    public Meal getMealById(Long id) {
        return mealRepositories.findById(id).orElseThrow(() ->
                new RuntimeException("No such meal with input id"));
    }

    public void connectTag(Long idMeal,Long idTags ){
        mealRepositories.findById(idMeal);
    }



}
