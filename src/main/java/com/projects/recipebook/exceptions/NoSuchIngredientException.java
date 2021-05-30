package com.projects.recipebook.exceptions;

public class NoSuchIngredientException extends RuntimeException {

    public NoSuchIngredientException(){}

    public NoSuchIngredientException(int id){
        super(String.format("Ingredient not found for id: '%id'", id));
    }
}
