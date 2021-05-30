package com.projects.recipebook.services;

import com.projects.recipebook.models.Recipe;
import com.projects.recipebook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> findAll(){
        return recipeRepository.findAll();
    }
}
