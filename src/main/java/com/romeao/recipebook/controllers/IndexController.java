package com.romeao.recipebook.controllers;

import com.romeao.recipebook.dto.RecipeDto;
import com.romeao.recipebook.dto.converters.RecipeToRecipeDto;
import com.romeao.recipebook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class IndexController {

    private final RecipeService recipeService;
    private final RecipeToRecipeDto toRecipeDto;

    public IndexController(RecipeService recipeService, RecipeToRecipeDto toRecipeDto) {
        this.recipeService = recipeService;
        this.toRecipeDto = toRecipeDto;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        Set<RecipeDto> recipes = new HashSet<>();
        recipeService.getAllRecipes().forEach(recipe -> recipes.add(toRecipeDto.convert(recipe)));
        model.addAttribute("recipes", recipes);
        return "index";
    }

}
