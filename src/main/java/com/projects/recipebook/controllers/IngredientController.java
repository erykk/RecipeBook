package com.projects.recipebook.controllers;

import com.projects.recipebook.beans.IngredientInfo;
import com.projects.recipebook.models.Ingredient;
import com.projects.recipebook.services.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IngredientController {
    @Autowired
    IngredientsService ingredientsService;

    @RequestMapping(value = "/allIngredients", method = RequestMethod.GET)
    public String allIngredients(Model model){
        List<Ingredient> ingredientList = ingredientsService.findAll();
        model.addAttribute("ingredients", ingredientList);
        return "allIngredients";

    }

    @RequestMapping(value = "/addIngredient", method = RequestMethod.GET)
    public String addIngredient(Model model){
        model.addAttribute("ingredient", new Ingredient());
        return "addIngredient";

    }

    @RequestMapping(value = "/addIngredient", method = RequestMethod.POST)
    public String addIngredient(@ModelAttribute Ingredient ingredient, Model model){
        ingredientsService.save(ingredient);
        List<Ingredient> ingredientList = ingredientsService.findAll();
        model.addAttribute("ingredients", ingredientList);
        return "allIngredients";

    }


    @RequestMapping(value = "/findIngredient", method = RequestMethod.GET)
    public void findIngredient(Model model){

    }
}
