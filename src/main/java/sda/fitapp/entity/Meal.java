package sda.fitapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
//    @ElementCollection
//    @CollectionTable(name = "meal_recepie_mapping",
//            joinColumns = {@JoinColumn(name = "meal_id", referencedColumnName = "id")})
//    @MapKeyColumn(name = "recipeName")
//    @Column(name = "proportion")
//    private Map<String, Double> listOfIngredients = new HashMap<>();
    @OneToMany
    private List<WrapperIngredientToProportion> listOfIngredients = new ArrayList<>();
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
}
