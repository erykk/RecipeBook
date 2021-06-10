package com.projects.recipebook.repositories;

import com.projects.recipebook.models.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe,String> {

}
