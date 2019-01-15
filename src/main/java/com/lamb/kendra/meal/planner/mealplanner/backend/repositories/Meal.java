package com.lamb.kendra.meal.planner.mealplanner.backend.repositories;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String notes;
    private boolean isFavorite;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "meal_recipe",
            joinColumns = {@JoinColumn(name= "mealId", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "recipeId", referencedColumnName = "id")})
    private Set<Recipe> mealRecipes = new HashSet<>();

    public Meal() {

    }

    public Meal(String name, String notes, Set<Recipe> mealRecipes) {
        this.name = name;
        this.notes = notes;
        this.mealRecipes = mealRecipes;
        this.isFavorite = false;
    }

    public Long getId() {
        return id;
    }

    public Meal setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Meal setName(String name) {
        this.name = name;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Meal setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Set<Recipe> getMealRecipes() {
        return mealRecipes;
    }

    public Meal setMealRecipes(Set<Recipe> mealRecipes) {
        this.mealRecipes = mealRecipes;
        return this;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public Meal setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }
}
