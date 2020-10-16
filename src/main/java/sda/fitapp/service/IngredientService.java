package sda.fitapp.service;

import org.springframework.stereotype.Service;
import sda.fitapp.entity.Ingredient;
import sda.fitapp.repository.JpaIngredientRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class IngredientService {

    private final JpaIngredientRepository jpaIngredientRepository;

    public IngredientService(JpaIngredientRepository jpaIngredientRepository) {
        this.jpaIngredientRepository = jpaIngredientRepository;
    }

    public Ingredient addIngredient(Ingredient ingredient){
        return jpaIngredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) {
        return jpaIngredientRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public void removeIngredientById(Long id) {
        Ingredient ingredientToRemove = jpaIngredientRepository.findById(id).orElseThrow(NoSuchElementException::new);
        jpaIngredientRepository.delete(ingredientToRemove);
    }

    public List<Ingredient> getAllIngredients() {
        return jpaIngredientRepository.findAll();
    }
}
