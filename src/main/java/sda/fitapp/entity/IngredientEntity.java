package sda.fitapp.entity;

import lombok.*;

import javax.persistence.*;

import static lombok.AccessLevel.*;

@Entity
@Data
@Builder
@AllArgsConstructor(access = PUBLIC)
@NoArgsConstructor
@Table(name = "ingredient")
@SequenceGenerator(name = "ingredient_seq")
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ingredient_seq")
    @Column(name = "id")
    private long id;
    private String name;
    private long kcal100g;
    private long gramsOfProteins;
    private long gramsOfCarbs;
    private long gramsOfFats;
    private boolean proteinProduct;
    private boolean carbProduct;
    private boolean fatProduct;
}

