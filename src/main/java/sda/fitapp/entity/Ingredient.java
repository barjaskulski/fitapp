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
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

