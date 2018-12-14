package com.lamb.kendra.meal.planner.mealplanner.controllers;

import com.lamb.kendra.meal.planner.mealplanner.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public Iterable<Recipe> getAllRecipes() {
        return recipeService.findAll();
    }

}
