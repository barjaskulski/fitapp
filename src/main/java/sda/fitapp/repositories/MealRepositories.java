package sda.fitapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.Ingredient;
import sda.fitapp.entity.Meal;

@Repository
public interface MealRepositories extends JpaRepository<Meal,Long> {
}
