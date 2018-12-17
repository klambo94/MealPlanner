package com.lamb.kendra.meal.planner.mealplanner.backend.controllers;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.backend.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public Iterable<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

    @RequestMapping(value = "recipes/favorites", method = RequestMethod.GET)
    public List<Recipe> getAllFavorites() {
        return recipeService.findAllFavorites();
    }

}
