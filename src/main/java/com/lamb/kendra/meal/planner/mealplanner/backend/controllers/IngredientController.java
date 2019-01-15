package com.lamb.kendra.meal.planner.mealplanner.backend.controllers;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Ingredient;
import com.lamb.kendra.meal.planner.mealplanner.backend.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    //TODO: Remove CrossOrigin's
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public Iterable<Ingredient> getAllIngredients() {
        return ingredientService.findAll();
    }
}
