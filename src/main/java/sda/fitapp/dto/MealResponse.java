package sda.fitapp.dto;

import sda.fitapp.entity.Ingredient;
import sda.fitapp.entity.Meal;
import sda.fitapp.service.MealService;

import java.util.ArrayList;
import java.util.List;

public class MealResponse {

    public Object mealKcalCalculation(Meal meal) {

        long proteinCounter = 0;
        long carbsCounter = 0;
        long fatCounter = 0;
        long mealValueOfKcal = proteinCounter * 4 + carbsCounter * 4 + fatCounter * 9;

        List newValuesOfIngredients = new ArrayList();
        int numbersOfIngredients = meal.getWrapperIngredientToProportionList().size();
        for (int i = 0; i < numbersOfIngredients; i++) {
            Ingredient newIngredietn = new Ingredient();
            double proportion = (Double.valueOf(meal.getWrapperIngredientToProportionList().get(i).getProportion()) / 100);

            newIngredietn.setKcal100g(Long.valueOf((long) (meal.getWrapperIngredientToProportionList().get(i).getIngredient().getKcal100g() * proportion)));
            newIngredietn.setGramsOfProteins(Long.valueOf((long) (meal.getWrapperIngredientToProportionList().get(i).getIngredient().getGramsOfProteins() * proportion)));
            newIngredietn.setGramsOfCarbs(Long.valueOf((long) (meal.getWrapperIngredientToProportionList().get(i).getIngredient().getGramsOfCarbs() * proportion)));
            newIngredietn.setGramsOfFats(Long.valueOf((long) (meal.getWrapperIngredientToProportionList().get(i).getIngredient().getGramsOfFats() * proportion)));
            proteinCounter = proteinCounter + newIngredietn.getGramsOfProteins();
            carbsCounter = carbsCounter + newIngredietn.getGramsOfCarbs();
            fatCounter = fatCounter + newIngredietn.getGramsOfFats();
            newValuesOfIngredients.add(newIngredietn);
        }
        Meal mealResult = new Meal();

        mealResult.setName(meal.getName());
        mealResult.setRecepture(meal.getRecepture());
        mealResult.setWrapperIngredientToProportionList(newValuesOfIngredients);
        mealResult.setGLUTENFREE(meal.isGLUTENFREE());
        mealResult.setLowIg(meal.isLowIg());
        mealResult.setVegan(meal.isVegan());
        mealResult.setVegetarian(meal.isVegetarian());
        mealResult.setValueOfKcal(mealValueOfKcal);
        mealResult.setValueOfProteins(proteinCounter);
        mealResult.setValueOfCarbs(carbsCounter);
        mealResult.setValueOfFats(fatCounter);
        return mealResult;
    }
}
