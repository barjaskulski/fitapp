package sda.fitapp.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import sda.fitapp.dto.IngredientProportion;
import sda.fitapp.entity.Meal;
import sda.fitapp.dto.MealRequest;
import sda.fitapp.entity.WrapperIngredientToProportion;
import sda.fitapp.repository.MealRepositories;
import sda.fitapp.repository.WrapperIngredientProportionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {
    MealRepositories mealRepositories;
    WrapperIngredientProportionRepository wrapperIngredientProportionRepository;

    public MealService(MealRepositories mealRepositories,
                       WrapperIngredientProportionRepository wrapperIngredientProportionRepository) {
        this.mealRepositories = mealRepositories;
        this.wrapperIngredientProportionRepository=wrapperIngredientProportionRepository;
    }

    public Meal addMeal(@RequestBody MealRequest meal){
        List<IngredientProportion> ingredientProportionList = meal.getIngredientWithProportions();
        List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
        for(IngredientProportion el : ingredientProportionList){
            WrapperIngredientToProportion wrapperEntity = new WrapperIngredientToProportion();
            wrapperEntity.setIngredient(ingredientRepository.findById(el.getIngredientId()));
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
}
