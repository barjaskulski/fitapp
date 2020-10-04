package sda.fitapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;
    private String name;
    private double kcal100g;
    private double gramsOfProteins;
    private double gramsOfCarbs;
    private double gramsOfFats;
    private boolean proteinProduct;
    private boolean carbProduct;
    private boolean fatProduct;
}
