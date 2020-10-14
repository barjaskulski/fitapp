package sda.fitapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.fitapp.entity.WrapperIngredientToProportion;


@Repository
public interface WrapperIngredientProportionRepository
        extends JpaRepository<WrapperIngredientToProportion,Long> {
}
