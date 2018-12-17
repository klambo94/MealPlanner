package com.lamb.kendra.meal.planner.mealplanner.backend.services;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Recipe> findAllFavorites() {
        return recipeRepository.findAllByIsFavoriteIsTrue();
    }
}
