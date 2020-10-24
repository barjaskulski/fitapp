package sda.fitapp.dto;

import sda.fitapp.entity.IngredientEntity;
import sda.fitapp.entity.MealEntity;
import sda.fitapp.entity.TagEntity;
import sda.fitapp.entity.WrapperIngredientToProportion;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class MealResponse {
    private MealEntity mealEntity;
    private long id;
    private String name;
    private String recepture;
    private List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    private List<TagEntity> tagEntityList = new ArrayList<>();
    private long mealProteins;
    private long mealCarbs;
    private long mealFats;
    private long mealKcal;

    public MealResponse(MealEntity mealEntity) {
        this.name = mealEntity.getName();
        this.recepture = mealEntity.getRecepture();
        this.wrapperIngredientToProportionList = mealEntity.getWrapperIngredientToProportionList();
        this.lowIg = mealEntity.isLowIg();
        this.vegetarian = mealEntity.isVegetarian();
        this.vegan = mealEntity.isVegan();
        this.glutenFree = mealEntity.isGlutenFree();
        this.tagEntityList = mealEntity.getTagEntityList();

        long proteinCounter = 0;
        for (WrapperIngredientToProportion product : mealEntity.getWrapperIngredientToProportionList()) {
            IngredientEntity newIngredietn = new IngredientEntity();
            double proportion = product.getProportion() / 100;
            newIngredietn.setGramsOfProteins((long) (product.getIngredientEntity().getGramsOfProteins() * proportion));
            proteinCounter = proteinCounter + newIngredietn.getGramsOfProteins();
        }
        mealProteins = proteinCounter;

        long carbsCounter = 0;
        for (WrapperIngredientToProportion product : mealEntity.getWrapperIngredientToProportionList()) {
            IngredientEntity newIngredietn = new IngredientEntity();
            double proportion = product.getProportion() / 100;
            newIngredietn.setGramsOfCarbs((long) (product.getIngredientEntity().getGramsOfCarbs() * proportion));
            carbsCounter = carbsCounter + newIngredietn.getGramsOfCarbs();
        }
        mealCarbs = carbsCounter;

        long fatCounter = 0;
        for (WrapperIngredientToProportion product : mealEntity.getWrapperIngredientToProportionList()) {
            IngredientEntity newIngredietn = new IngredientEntity();
            double proportion = product.getProportion() / 100;
            newIngredietn.setGramsOfFats((long) (product.getIngredientEntity().getGramsOfFats() * proportion));
            fatCounter = fatCounter + newIngredietn.getGramsOfFats();
        }
        mealFats=fatCounter;

        mealKcal=(mealProteins * 4) + (mealCarbs* 4) + (mealFats * 9);

    }
}
