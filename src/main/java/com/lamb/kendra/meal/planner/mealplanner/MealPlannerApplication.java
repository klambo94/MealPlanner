package com.lamb.kendra.meal.planner.mealplanner;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Meal;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.backend.services.MealService;
import com.lamb.kendra.meal.planner.mealplanner.backend.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MealPlannerApplication {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private MealService mealService;

    public static void main(String[] args) {
        SpringApplication.run(MealPlannerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Recipe recipe1 = new Recipe("20 Minute Skillet Fajitas", "https://www.theironyou.com/2015/10/20-minute-skillet-chicken-fajitas.html?m=1", "Can be used with steak or chicken");
            Recipe recipe2 = new Recipe("Hawaiian Porkchops", null, "See Cook It Quick page 235");
            Recipe recipe3 = new Recipe("Sizzling Asparagus", null, "See Cook It Quick page 240");
            recipe1.setFavorite(true);
            recipeService.save(recipe1);
            recipeService.save(recipe2);
            recipeService.save(recipe3);

            Set<Recipe> recipesForMeal1 = new HashSet<>();
            recipesForMeal1.add(recipe2);
            recipesForMeal1.add(recipe3);

            Set<Recipe> recipesForMeal2 = new HashSet<>();
            recipesForMeal2.add(recipe1);

            Meal meal1 = new Meal("Hawaiian Porkchops and Asparagus", null, recipesForMeal1);
            Meal meal2 = new Meal("Fajitas", "Test Note", recipesForMeal2);

            meal1.setFavorite(true);

            mealService.save(meal1);
            mealService.save(meal2);
        };
    }
}

