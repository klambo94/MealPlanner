package com.lamb.kendra.meal.planner.mealplanner.repositories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String link;
    private String notes;

    public Recipe() {

    }

    public Recipe(String name, String link, String notes) {
        this.name = name;
        this.link = link;
        this.notes = notes;
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
}
