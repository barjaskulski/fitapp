package sda.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.Ingredient;

@Repository
public interface JpaIngredientRepository extends JpaRepository<Ingredient, Long> {
}
