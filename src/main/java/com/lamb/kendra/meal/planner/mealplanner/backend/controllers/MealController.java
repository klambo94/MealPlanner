package com.lamb.kendra.meal.planner.mealplanner.backend.controllers;


import com.lamb.kendra.meal.planner.mealplanner.backend.services.MealService;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;
    //TODO: Remove CrossOrigin's
    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "meals", method = RequestMethod.GET)
    public Iterable<Meal> getMeals() {
        return mealService.findAll();
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value = "meals/favorites", method = RequestMethod.GET)
    public List<Meal> getFavorites() {
        return mealService.findAllFavorites();
    }
}
