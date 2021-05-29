package com.projects.recipebook.exceptions;

public class NoSuchIngredient extends RuntimeException {

    public NoSuchIngredient(){}

    public NoSuchIngredient(int id){
        super(String.format("Ingredient not found for id: '%id'", id));
    }
}
