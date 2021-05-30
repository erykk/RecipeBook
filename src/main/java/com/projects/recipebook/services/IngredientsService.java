package com.projects.recipebook.services;

import com.projects.recipebook.exceptions.NoSuchIngredient;
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
    public void save(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

    private boolean ingredientExists(String name){
        Ingredient ingredient;
        try {
            ingredient = ingredientRepository.findByName(name);
        } catch (NoSuchIngredient e) {
            return false;
        }
        return true;
    }
}
