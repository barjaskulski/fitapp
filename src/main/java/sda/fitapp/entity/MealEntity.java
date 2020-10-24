package sda.fitapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@SequenceGenerator(name = "meal_seq")
public class MealEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meal_seq")
    private long id;
    private String name;
    private String recepture;
    @OneToMany
    @JoinColumn(name = "id_ingdrient_to_proportion")
    private List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean glutenFree;
    @ManyToMany
    @JoinTable(
            name = "tags_meals",
            joinColumns = { @JoinColumn(name = "meal_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private List<TagEntity> tagEntityList = new ArrayList<>();

}
