package com.romeao.recipebook.controllers;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.RecipeDto;
import com.romeao.recipebook.dto.converters.RecipeDtoToRecipe;
import com.romeao.recipebook.dto.converters.RecipeToRecipeDto;
import com.romeao.recipebook.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class RecipeController {

    private final RecipeService recipeService;
    private final RecipeDtoToRecipe toRecipeConverter;
    private final RecipeToRecipeDto toRecipeDtoConverter;

    public RecipeController(RecipeService recipeService,
                            RecipeDtoToRecipe toRecipeConverter,
                            RecipeToRecipeDto toRecipeDtoConverter) {
        this.recipeService = recipeService;
        this.toRecipeConverter = toRecipeConverter;
        this.toRecipeDtoConverter = toRecipeDtoConverter;
    }

    @RequestMapping("/recipes")
    public String getIndexPage(Model model) {
        Set<RecipeDto> recipes = new HashSet<>();
        recipeService.getAllRecipes()
                .forEach(recipe -> recipes.add(toRecipeDtoConverter.convert(recipe)));
        model.addAttribute("recipes", recipes);
        return "recipe/manage";
    }

    @RequestMapping("recipe/{id}")
    public String showById(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.valueOf(id));
        if (recipe == null) { return "redirect:/"; }
        model.addAttribute("recipe", recipe);
        return "recipe/show";
    }

    @RequestMapping("/recipe/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        model.addAttribute("isNewRecipe", true);

        return "recipe/recipeForm";
    }

    @RequestMapping("recipe/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        Recipe recipe = recipeService.findById(Long.valueOf(id));
        if (recipe == null) { return "redirect:/"; }
        model.addAttribute("recipe", recipe);
        model.addAttribute("isNewRecipe", false);
        return "recipe/recipeForm";
    }

    @PostMapping("recipe")
    public String saveOrUpdateRecipe(@ModelAttribute RecipeDto command) {
        Recipe savedRecipe = recipeService.save(toRecipeConverter.convert(command));
        return "redirect:/recipe/" + savedRecipe.getId();
    }

    @RequestMapping("recipe/{id}/delete")
    public String deleteRecipe(@PathVariable String id) {
        recipeService.deleteById(Long.valueOf(id));
        return "redirect:/recipes";
    }
}
