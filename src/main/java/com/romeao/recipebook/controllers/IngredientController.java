package com.romeao.recipebook.controllers;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.IngredientDto;
import com.romeao.recipebook.dto.converters.IngredientToIngredientDto;
import com.romeao.recipebook.services.IngredientService;
import com.romeao.recipebook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final RecipeService recipeService;
    private final IngredientToIngredientDto toIngredientDto;

    public IngredientController(IngredientService ingredientService,
                                RecipeService recipeService,
                                IngredientToIngredientDto toIngredientDto) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.toIngredientDto = toIngredientDto;
    }

    @RequestMapping("/recipe/{id}/ingredients")
    public String manageIngredients(@PathVariable String id, Model model) {
        Long recipeId = Long.valueOf(id);
        Recipe recipe = recipeService.findById(recipeId);
        List<IngredientDto> ingredients = new ArrayList<>();
        ingredientService.getAllIngredients(recipeId)
                .forEach(ingredient -> ingredients.add(toIngredientDto.convert(ingredient)));
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("recipeId", id);
        model.addAttribute("recipeDescription", recipe.getDescription());
        return "recipe/ingredient/manage";
    }
}
