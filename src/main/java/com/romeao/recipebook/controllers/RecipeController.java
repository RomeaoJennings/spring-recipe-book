package com.romeao.recipebook.controllers;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.RecipeDto;
import com.romeao.recipebook.dto.converters.RecipeConverter;
import com.romeao.recipebook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RecipeController {

    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping(path = "/recipes")
    public String getIndexPage(Model model) {
        Set<RecipeDto> recipes = new HashSet<>();
        recipeService.getAllRecipes()
                .forEach(recipe -> recipes.add(RecipeConverter.toDto(recipe)));
        model.addAttribute("recipes", recipes);
        return "recipe/manage";
    }

    @GetMapping(path = "recipe/{id}")
    public String showById(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.valueOf(id));
        if (recipe == null) { return "redirect:/"; }
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }

    @GetMapping(path = "/recipes/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        model.addAttribute("isNewRecipe", true);

        return "recipe/recipeForm";
    }

    @GetMapping(path = "recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.valueOf(id));
        if (recipe == null) { return "redirect:/"; }
        model.addAttribute("recipe", recipe);
        model.addAttribute("isNewRecipe", false);
        model.addAttribute("allCategories", recipeService.getAllCategories());
        return "recipe/recipeForm";
    }

    @PostMapping(path = "/recipe", params = {"saveRecipe", "!editIngredients"})
    public String updateRecipe(@ModelAttribute RecipeDto dto) {
        Recipe savedRecipe = recipeService.save(RecipeConverter.toRecipe(dto));
        return "redirect:/recipe/" + savedRecipe.getId();
    }

    @PostMapping(path = "/recipe", params = {"editIngredients", "!saveRecipe"})
    public String saveRecipeAndEditIngredients(@ModelAttribute RecipeDto recipeDto) {
        Recipe savedRecipe = recipeService.save(RecipeConverter.toRecipe(recipeDto));
        return "redirect:/recipe/" + savedRecipe.getId() + "/ingredients";
    }

    @GetMapping(path = "recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/recipes";
    }
}
