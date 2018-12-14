package com.lamb.kendra.meal.planner.mealplanner.services;

import com.lamb.kendra.meal.planner.mealplanner.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Iterable<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    public void save(Recipe recipe) {
        recipeRepository.save(recipe);
    }
}
