package com.projects.recipebook.repositories;

import com.projects.recipebook.models.Ingredient;
import com.projects.recipebook.models.RecipeComponent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeComponentRepository extends JpaRepository<RecipeComponent, Integer> {
    public RecipeComponent save(RecipeComponent rC);
}
