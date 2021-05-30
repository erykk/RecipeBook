package com.projects.recipebook.exceptions;

public class NoSuchRecipeException extends RuntimeException {

    public NoSuchRecipeException(){}

    public NoSuchRecipeException(int id){
        super(String.format("Recipe not found for id: '%i'", id));
    }
}
