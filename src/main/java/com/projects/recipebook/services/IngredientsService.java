package com.projects.recipebook.services;

import com.projects.recipebook.exceptions.NoSuchIngredientException;
import com.projects.recipebook.models.Ingredient;
import com.projects.recipebook.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientsService {
    @Autowired
    IngredientRepository ingredientRepository;

    public List<Ingredient> findAll() {
        return ingredientRepository.findAll();
    }

    public Ingredient findByName(String name) {
        return ingredientRepository.findByName(name);
    }
    public Ingredient save(Ingredient ingredient) {
        return ingredientRepository.save(ingredient);
    }

    public boolean ingredientExists(String name){
        Ingredient ingredient;
        try {
            ingredient = ingredientRepository.findByName(name);
        } catch (NoSuchIngredientException e) {
            return false;
        }
        return true;
    }
}
