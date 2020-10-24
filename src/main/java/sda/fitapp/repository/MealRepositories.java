package sda.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.MealEntity;

@Repository
public interface MealRepositories extends JpaRepository<MealEntity,Long> {
}
