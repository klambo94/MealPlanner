package com.lamb.kendra.meal.planner.mealplanner;

import com.lamb.kendra.meal.planner.mealplanner.repositories.Recipe;
import com.lamb.kendra.meal.planner.mealplanner.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MealPlannerApplication {

    @Autowired
    private RecipeService recipeService;

    public static void main(String[] args) {
        SpringApplication.run(MealPlannerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            Recipe recipe1 = new Recipe("20 Minute Skillet Fajitas", "https://www.theironyou.com/2015/10/20-minute-skillet-chicken-fajitas.html?m=1", "Can be used with steak or chicken");
            Recipe recipe2 = new Recipe("Hawaiian Porkchops", null, "See Cook It Quick page 235");
            recipeService.save(recipe1);
            recipeService.save(recipe2);
        };
    }
}

