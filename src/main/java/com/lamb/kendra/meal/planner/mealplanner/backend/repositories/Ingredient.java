package com.lamb.kendra.meal.planner.mealplanner.backend.repositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private double amt;
    private String measurementType;
    private String ingredientName;

    @ManyToMany(mappedBy = "ingredients")
    @JsonIgnore
    private Set<Recipe> ingredientRecipes;

    public Ingredient() {
    }

    public Ingredient(double amt, String measurementType, String ingredientName) {
        this.amt = amt;
        this.measurementType = measurementType;
        this.ingredientName = ingredientName;
    }

    public Long getId() {
        return id;
    }

    public Ingredient setId(Long id) {
        this.id = id;
        return this;
    }

    public double getAmt() {
        return amt;
    }

    public Ingredient setAmt(double amt) {
        this.amt = amt;
        return this;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public Ingredient setMeasurementType(String measurementType) {
        this.measurementType = measurementType;
        return this;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public Ingredient setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
        return this;
    }

    public Set<Recipe> getIngredientRecipes() {
        return ingredientRecipes;
    }

    public Ingredient setIngredientRecipes(Set<Recipe> ingredientRecipes) {
        this.ingredientRecipes = ingredientRecipes;
        return this;
    }
}
