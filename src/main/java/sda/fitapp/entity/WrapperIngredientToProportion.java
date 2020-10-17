package sda.fitapp.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class WrapperIngredientToProportion {
    @Id
    @GeneratedValue
    Long id;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    Ingredient ingredient;
    Double proportion;

}
