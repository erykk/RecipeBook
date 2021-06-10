package com.projects.recipebook.controllers;

import com.projects.recipebook.beans.RecipeInfo;
import com.projects.recipebook.models.Amount;
import com.projects.recipebook.models.Recipe;
import com.projects.recipebook.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class RecipeController {

    @Autowired
    RecipeRepository recipeRepository;

    @RequestMapping(value = "/addRecipe", method = RequestMethod.GET)
    public String addRecipe(Model model ){
        model.addAttribute("recipeInfo", new RecipeInfo());
        return "addRecipe";
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public String viewRecipes(Model model ){
        model.addAttribute("recipes", recipeRepository.findAll());
        return "allRecipes";
    }

    @RequestMapping(value = "/viewRecipe/{id}", method = RequestMethod.GET)
    public String viewRecipes(Model model, @PathVariable("id") String id){
        Optional<Recipe> recipe = recipeRepository.findById(id);
        recipe.ifPresent(value -> model.addAttribute("recipe", value));
        return "viewRecipe";
    }

    @RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
    public String addRecipe(Model model, @ModelAttribute("recipeInfo") RecipeInfo recipeInfo) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeInfo.getName());
        recipe.setDesc(recipeInfo.getDesc());
        recipe.setIngredients(parseIngredients(recipeInfo.getIngredients()));
        recipeRepository.save(recipe);

        model.addAttribute("recipes", recipeRepository.findAll());
        return "allRecipes";
    }



    private Map<String, Amount> parseIngredients(String ingredients){
        Map<String, Amount> map = new HashMap<>();
        for (String item : ingredients.split("\n")){
            String[] str = item.split(",");
            map.put(str[0], new Amount(str[1], str[2]));
        }
        return map;
    }
}
