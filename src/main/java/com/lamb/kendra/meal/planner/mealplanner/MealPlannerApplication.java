package com.lamb.kendra.meal.planner.mealplanner;

import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Ingredient;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Meal;
import com.lamb.kendra.meal.planner.mealplanner.backend.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.backend.services.IngredientService;
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

    @Autowired
    private IngredientService ingredientService;

    public static void main(String[] args) {
        SpringApplication.run(MealPlannerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Ingredient chicken = new Ingredient(1, "lb", "Chicken breast");
            Ingredient bellPeppers = new Ingredient(2, "count", "Bell peppers, any color");
            Ingredient onion = new Ingredient(1, "whole", "Vindella onion");
            Ingredient pork = new Ingredient(4, "count", "Pork Chops");
            Ingredient soySauce = new Ingredient(4, "oz", "Soy Sauce");
            Ingredient brownSugar = new Ingredient(1, "tbsp", "Brown Sugar");
            Ingredient pineapple = new Ingredient(8, "oz", "Pineapple Slices");
            Ingredient asparagus = new Ingredient(12, "spears", "Asparagus");
            Ingredient bacon = new Ingredient(.5, "lb", "Bacon");

            ingredientService.save(chicken);
            ingredientService.save(bellPeppers);
            ingredientService.save(onion);
            ingredientService.save(pork);
            ingredientService.save(soySauce);
            ingredientService.save(pineapple);
            ingredientService.save(brownSugar);
            ingredientService.save(asparagus);
            ingredientService.save(bacon);

            Set<Ingredient> ingredients1 = new HashSet<>();
            Set<Ingredient> ingredients2 = new HashSet<>();
            Set<Ingredient> ingredients3 = new HashSet<>();

            ingredients1.add(chicken);
            ingredients1.add(bellPeppers);
            ingredients1.add(onion);

            ingredients2.add(pork);
            ingredients2.add(onion);
            ingredients2.add(soySauce);
            ingredients2.add(brownSugar);
            ingredients2.add(pineapple);

            ingredients3.add(asparagus);
            ingredients3.add(bacon);

            Recipe recipe1 = new Recipe("20 Minute Skillet Fajitas", "https://www.theironyou.com/2015/10/20-minute-skillet-chicken-fajitas.html?m=1", "Can be used with steak or chicken", ingredients1);
            Recipe recipe2 = new Recipe("Hawaiian Porkchops", null, "See Cook It Quick page 235", ingredients2);
            Recipe recipe3 = new Recipe("Sizzling Asparagus", null, "See Cook It Quick page 240", ingredients3);
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

