package sda.fitapp.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@SequenceGenerator(name = "ingredientwrapper_seq")
public class WrapperIngredientToProportion {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "ingredientwrapper_seq")
    Long id;
    @ManyToOne
    @JoinColumn(name = "id_ingredient")
    Ingredient ingredient;
    Double proportion;

}
