package sda.fitapp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class MealRequest {
    private String name;
    private String recipe;
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean GLUTENFREE;
    private List<IngredientProportion> ingredientWithProportions;
}


