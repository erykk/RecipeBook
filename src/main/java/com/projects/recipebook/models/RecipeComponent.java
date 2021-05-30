package com.projects.recipebook.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class RecipeComponent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToMany
    private List<Recipe> recipeList;
    @OneToOne
    private Ingredient ingredient;
    private String modifier;
    private long quantity;
    private String measure;

    public RecipeComponent(){}
    public RecipeComponent(Ingredient ingredient, String modifier, long quantity, String measure) {
        this.ingredient = ingredient;
        this.modifier = modifier;
        this.quantity = quantity;
        this.measure = measure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }
}
