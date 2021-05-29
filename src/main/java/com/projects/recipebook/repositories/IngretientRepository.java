package com.projects.recipebook.repositories;

import com.projects.recipebook.exceptions.NoSuchIngredient;
import com.projects.recipebook.models.Ingredient;
import org.springframework.stereotype.Repository;

@Repository
public interface IngretientRepository {
    Ingredient findById(int id) throws NoSuchIngredient;

}
