package sda.fitapp.entity;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Data
public class WrapperIngredientToProportion {
    @Id
    @GeneratedValue
    private String id;

    @ManyToOne
    private Ingredient ingredient;
    private Double proportion;


}
