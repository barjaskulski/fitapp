package sda.fitapp.dto;

import sda.fitapp.entity.Ingredient;
import sda.fitapp.entity.Meal;
import sda.fitapp.entity.WrapperIngredientToProportion;

public class MealResponse {
    private Meal meal;
    private String name = meal.getName();
    private String recepture = meal.getRecepture();
    private boolean lowIg = meal.isLowIg();
    private boolean vegetarian = meal.isVegetarian();
    private boolean vegan = meal.isVegan();
    private boolean glutenFree = meal.isGlutenFree();

    public long getMealProteins() {
        long proteinCounter = 0;
        for (WrapperIngredientToProportion product : meal.getWrapperIngredientToProportionList()) {
            Ingredient newIngredietn = new Ingredient();
            double proportion = product.getProportion() / 100;
            newIngredietn.setGramsOfProteins((long) (product.getIngredient().getGramsOfProteins() * proportion));
            proteinCounter = proteinCounter + newIngredietn.getGramsOfProteins();
        }
        return proteinCounter;
    }

    public long getMealCarbs() {
        long carbsCounter = 0;
        for (WrapperIngredientToProportion product : meal.getWrapperIngredientToProportionList()) {
            Ingredient newIngredietn = new Ingredient();
            double proportion = product.getProportion() / 100;
            newIngredietn.setGramsOfCarbs((long) (product.getIngredient().getGramsOfCarbs() * proportion));
            carbsCounter = carbsCounter + newIngredietn.getGramsOfCarbs();
        }
        return carbsCounter;
    }

    public long getMealFats() {
        long fatCounter = 0;
        for (WrapperIngredientToProportion product : meal.getWrapperIngredientToProportionList()) {
            Ingredient newIngredietn = new Ingredient();
            double proportion = product.getProportion() / 100;
            newIngredietn.setGramsOfFats((long) (product.getIngredient().getGramsOfFats() * proportion));
            fatCounter = fatCounter + newIngredietn.getGramsOfFats();
        }
        return fatCounter;
    }

    public long getMealKcal() {
        return (getMealProteins() * 4) + (getMealCarbs() * 4) + (getMealFats() * 9);
    }
}
