package com.projects.recipebook.services;

import com.projects.recipebook.models.RecipeComponent;
import com.projects.recipebook.repositories.RecipeComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeComponentService {
    @Autowired
    RecipeComponentRepository recipeComponentRepository;

    public RecipeComponent save(RecipeComponent rC) {
        return recipeComponentRepository.save(rC);
    }
}
