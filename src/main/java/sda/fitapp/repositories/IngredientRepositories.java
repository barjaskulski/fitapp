package sda.fitapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.fitapp.entity.Ingredient;

public interface IngredientRepositories extends JpaRepository<Ingredient,Long> {
}
