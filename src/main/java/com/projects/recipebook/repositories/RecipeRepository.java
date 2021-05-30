package com.projects.recipebook.repositories;

import com.projects.recipebook.exceptions.NoSuchRecipeException;
import com.projects.recipebook.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    Recipe findById(int id) throws NoSuchRecipeException;
}
