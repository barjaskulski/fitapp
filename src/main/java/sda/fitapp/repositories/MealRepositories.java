package sda.fitapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sda.fitapp.entity.Ingredient;
import sda.fitapp.entity.Meal;

public interface MealRepositories extends JpaRepository<Meal,Long> {
}
