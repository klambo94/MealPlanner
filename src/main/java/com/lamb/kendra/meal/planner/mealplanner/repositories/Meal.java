package com.lamb.kendra.meal.planner.mealplanner.repositories;


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

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "meal_recipe",
                joinColumns = {@JoinColumn(name= "mealId", referencedColumnName = "id")},
                inverseJoinColumns = {@JoinColumn(name = "recipeId", referencedColumnName = "id")})
    private Set<Recipe> recipes = new HashSet<>();

    public Meal() {

    }

    public Meal(String name, String notes, Set<Recipe> recipes) {
        this.name = name;
        this.notes = notes;
        this.recipes = recipes;
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

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public Meal setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
        return this;
    }
}
