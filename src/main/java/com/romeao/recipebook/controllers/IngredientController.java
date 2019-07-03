package com.romeao.recipebook.controllers;

import com.romeao.recipebook.dto.IngredientDto;
import com.romeao.recipebook.dto.converters.IngredientToIngredientDto;
import com.romeao.recipebook.services.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final IngredientToIngredientDto toIngredientDto;

    public IngredientController(IngredientService ingredientService,
                                IngredientToIngredientDto toIngredientDto) {
        this.ingredientService = ingredientService;
        this.toIngredientDto = toIngredientDto;
    }

    @RequestMapping("/recipe/{id}/ingredients")
    public String manageIngredients(@PathVariable String id, Model model) {
        List<IngredientDto> ingredients = new ArrayList<>();
        ingredientService.getAllIngredients(Long.valueOf(id))
                .forEach(ingredient -> ingredients.add(toIngredientDto.convert(ingredient)));
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("recipeId", id);
        return "recipe/ingredient/manage";
    }
}
