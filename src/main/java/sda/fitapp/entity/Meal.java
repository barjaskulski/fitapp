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
    @OneToMany
    @JoinColumn(name = "id_ingdrient_to_proportion")
    private List<WrapperIngredientToProportion> wrapperIngredientToProportionList = new ArrayList<>();
    private boolean lowIg;
    private boolean vegetarian;
    private boolean vegan;
    private boolean GLUTENFREE;

    //W ten sposób musze dodawać istniejące ingdienty
//    więc kurwa nie dziwne że się jebie
}
