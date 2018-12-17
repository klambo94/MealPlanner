package com.lamb.kendra.meal.planner.mealplanner.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface RecipeRepository extends CrudRepository<Recipe, Long> {

    List<Recipe> findAllByIsFavoriteIsTrue();
}
