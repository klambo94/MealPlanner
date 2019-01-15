package com.lamb.kendra.meal.planner.mealplanner.backend.services;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Ingredient;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    public void save(Ingredient meal) {
        ingredientRepository.save(meal);
    }

    public Iterable<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

}
