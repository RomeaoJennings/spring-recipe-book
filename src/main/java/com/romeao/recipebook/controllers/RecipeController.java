package com.romeao.recipebook.controllers;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(name = "/recipe")
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.valueOf(id));
        // TODO: HANDLE NULL RECIPE WITH ERROR OR REDIRECT
        model.addAttribute("recipe", recipe);
        return "recipes/show";
    }
}
