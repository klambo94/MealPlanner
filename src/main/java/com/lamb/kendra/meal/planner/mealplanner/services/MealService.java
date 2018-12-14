package com.lamb.kendra.meal.planner.mealplanner.services;

import com.lamb.kendra.meal.planner.mealplanner.repositories.Meal;
import com.lamb.kendra.meal.planner.mealplanner.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Iterable<Meal> findAll(){
        return mealRepository.findAll();
    }

    public void save(Meal meal) {
        mealRepository.save(meal);
    }
}
