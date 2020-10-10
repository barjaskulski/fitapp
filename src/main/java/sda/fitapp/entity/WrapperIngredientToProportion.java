package sda.fitapp.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class WrapperIngredientToProportion {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    private Ingredient ingredient;
    private Double proportion;


}
