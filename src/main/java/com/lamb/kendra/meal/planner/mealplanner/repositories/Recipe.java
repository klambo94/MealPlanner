package com.lamb.kendra.meal.planner.mealplanner.repositories;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
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

    @ManyToMany(mappedBy = "recipes")
    @JsonIgnore
    private Set<Meal> meals;

    public Recipe() {

    }

    public Recipe(String name, String link, String notes) {
        this.name = name;
        this.link = link;
        this.notes = notes;
        this.isFavorite = false;
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
}
