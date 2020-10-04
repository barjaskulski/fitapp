package sda.fitapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Data
@Table(name = "meals")
public class Meal {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String recepture;
    @ElementCollection
    @CollectionTable(name = "meal_recepie_mapping",
            joinColumns = {@JoinColumn(name = "meal_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "recipeName")
    @Column(name = "proportion")
    private Map<String, Double> listOfIngredients = new HashMap<>();
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;

}
