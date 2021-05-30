package com.projects.recipebook.repositories;

import com.projects.recipebook.exceptions.NoSuchIngredientException;
import com.projects.recipebook.models.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
    List<Ingredient> findAll();
    Ingredient findById(int id) throws NoSuchIngredientException;
    Ingredient findByName(String name) throws NoSuchIngredientException;

}
