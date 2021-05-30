package com.projects.recipebook.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToMany
    private List<RecipeComponent> componentList;

    public Recipe(){}

    public Recipe(String name, List<RecipeComponent> componentList) {
        this.name = name;
        this.componentList = componentList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<RecipeComponent> getIngredientList() {
        return componentList;
    }

    public void setIngredientList(List<RecipeComponent> componentList) {
        this.componentList = componentList;
    }
}
