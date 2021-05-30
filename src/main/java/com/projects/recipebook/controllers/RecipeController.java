package com.projects.recipebook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RecipeController {
    @Autowired


    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public String recipies(Model model){
        return "allRecipies";
    }
}
