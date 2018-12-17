package com.lamb.kendra.meal.planner.mealplanner.controllers;


import com.lamb.kendra.meal.planner.mealplanner.repositories.Meal;
import com.lamb.kendra.meal.planner.mealplanner.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @RequestMapping(value = "meals", method = RequestMethod.GET)
    public Iterable<Meal> getMeals() {
        return mealService.findAll();
    }

    @RequestMapping(value = "meals/favorites", method = RequestMethod.GET)
    public List<Meal> getFavorites() {
        return mealService.findAllFavorites();
    }
}
