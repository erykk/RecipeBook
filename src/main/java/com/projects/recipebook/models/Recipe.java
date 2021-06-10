package com.projects.recipebook.models;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "recipebook")
public class Recipe {
    @Id
    private String id;
    private String name;
    private String desc;
    private Map<String, Amount> ingredients;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Map<String, Amount> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Amount> ingredients) {
        this.ingredients = ingredients;
    }
}
