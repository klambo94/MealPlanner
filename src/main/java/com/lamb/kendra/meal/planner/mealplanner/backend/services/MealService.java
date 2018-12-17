package com.lamb.kendra.meal.planner.mealplanner.backend.services;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Meal;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Meal> findAllFavorites() {
        return mealRepository.findAllByIsFavoriteIsTrue();
    }

}
