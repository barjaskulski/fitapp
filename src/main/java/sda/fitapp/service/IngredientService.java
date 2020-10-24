package sda.fitapp.service;

import org.springframework.stereotype.Service;
import sda.fitapp.entity.IngredientEntity;
import sda.fitapp.repository.JpaIngredientRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientService {

    private final JpaIngredientRepository jpaIngredientRepository;

    public IngredientService(JpaIngredientRepository jpaIngredientRepository) {
        this.jpaIngredientRepository = jpaIngredientRepository;
    }

    public IngredientEntity addIngredient(IngredientEntity ingredientEntity){
        return jpaIngredientRepository.save(ingredientEntity);
    }

    public IngredientEntity getIngredientById(Long id) {
        return jpaIngredientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void removeIngredientById(Long id) {
        IngredientEntity ingredientEntityToRemove = jpaIngredientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        jpaIngredientRepository.delete(ingredientEntityToRemove);
    }

    public List<IngredientEntity> getAllIngredients() {
        return jpaIngredientRepository.findAll();
    }
}
