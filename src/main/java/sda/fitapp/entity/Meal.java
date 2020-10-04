package sda.fitapp.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String recepture;
    //private Map<Ingredient, Long> listOfIngredients;
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
}
