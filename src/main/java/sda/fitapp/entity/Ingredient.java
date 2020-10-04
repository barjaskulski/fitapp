package sda.fitapp.entity;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@Builder
@NoArgsConstructor
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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
