package sda.fitapp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Map;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Meal {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String recepture;
    private Map<Ingredients, Long> listOfIngredients;
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
}
