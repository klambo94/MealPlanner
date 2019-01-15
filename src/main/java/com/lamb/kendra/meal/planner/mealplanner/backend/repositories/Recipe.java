package com.lamb.kendra.meal.planner.mealplanner.backend.repositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String link;
    private String notes;
    private boolean isFavorite;

    @ManyToMany(mappedBy = "mealRecipes")
    @JsonIgnore
    private Set<Meal> meals;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "recipe_ingredient",
            joinColumns = {@JoinColumn(name= "recipe_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ingredientId", referencedColumnName = "id")})
    private Set<Ingredient> ingredients = new HashSet<>();

    public Recipe() {

    }

    public Recipe(String name, String link, String notes, Set<Ingredient> ingredients) {
        this.name = name;
        this.link = link;
        this.notes = notes;
        this.isFavorite = false;
        this.ingredients = ingredients;
    }

    public Long getId() {
        return id;
    }

    public Recipe setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Recipe setName(String name) {
        this.name = name;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Recipe setLink(String link) {
        this.link = link;
        return this;
    }

    public String getNotes() {
        return notes;
    }

    public Recipe setNotes(String notes) {
        this.notes = notes;
        return this;
    }

    public Set<Meal> getMeals() {
        return meals;
    }

    public Recipe setMeals(Set<Meal> meals) {
        this.meals = meals;
        return this;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public Recipe setFavorite(boolean favorite) {
        isFavorite = favorite;
        return this;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public Recipe setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
        return this;
    }
}
