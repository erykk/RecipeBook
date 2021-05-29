package com.projects.recipebook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IngredientController {
    @RequestMapping(value = "/allIngredients", method = RequestMethod.GET)
    public void allIngredients(Model model){

    }

    @RequestMapping(value = "/findIngredient", method = RequestMethod.GET)
    public void findIngredient(Model model){

    }
}
