package com.projects.recipebook.controllers;

import com.projects.recipebook.beans.RecipeInfo;
import com.projects.recipebook.exceptions.NoSuchIngredientException;
import com.projects.recipebook.models.Ingredient;
import com.projects.recipebook.models.Recipe;
import com.projects.recipebook.models.RecipeComponent;
import com.projects.recipebook.services.IngredientsService;
import com.projects.recipebook.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    IngredientsService ingredientsService;

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public String recipes(Model model){
        model.addAttribute("recipes", recipeService.findAll());
        return "allRecipes";
    }

    @RequestMapping(value = "/addRecipe", method = RequestMethod.GET)
    public String addRecipe(Model model){
        model.addAttribute("recipeInfo", new Recipe());
        return "addRecipe";
    }

    @RequestMapping(value = "/addRecipe", method = RequestMethod.POST)
    public String addRecipe(@ModelAttribute RecipeInfo recipeInfo, Model model){
        String ingredients = recipeInfo.getIngredients();
        List<RecipeComponent> recipeComponentList = parseIngredients(ingredients);

        Recipe recipe = recipeService.save(new Recipe());
        recipe.setName(recipeInfo.getName());

        for (RecipeComponent rC : recipeComponentList){

        }

        model.addAttribute("recipes", recipeService.findAll());
        return "allRecipes";
    }

    private List<RecipeComponent> parseIngredients(String ingredients){
        List<RecipeComponent> recipeComponentList = new ArrayList<>();
        for (String component : Arrays.asList(ingredients.split("\n"))){
            Ingredient ingredient;
            String[] str = component.split(",");
            try {
                ingredient = ingredientsService.findByName(str[0]);
            } catch (NoSuchIngredientException e){
                ingredient = ingredientsService.save(new Ingredient(str[0]));           }

            RecipeComponent rC = new RecipeComponent(ingredient, str[1], Long.parseLong(str[2]), str[3]);
            recipeComponentList.add(rC);
        }
        return recipeComponentList;
    }



}
