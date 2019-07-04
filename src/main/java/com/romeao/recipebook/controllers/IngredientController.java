package com.romeao.recipebook.controllers;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.IngredientDto;
import com.romeao.recipebook.dto.converters.IngredientDtoToIngredient;
import com.romeao.recipebook.dto.converters.IngredientToIngredientDto;
import com.romeao.recipebook.dto.converters.UnitOfMeasureToUnitOfMeasureDto;
import com.romeao.recipebook.services.IngredientService;
import com.romeao.recipebook.services.RecipeService;
import com.romeao.recipebook.services.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;
    private final RecipeService recipeService;
    private final UnitOfMeasureService unitOfMeasureService;
    private final IngredientToIngredientDto toIngredientDto;
    private final IngredientDtoToIngredient toIngredient;
    private final UnitOfMeasureToUnitOfMeasureDto toUnitOfMeasureDto;

    public IngredientController(IngredientService ingredientService,
                                RecipeService recipeService,
                                UnitOfMeasureService unitOfMeasureService,
                                IngredientToIngredientDto toIngredientDto,
                                IngredientDtoToIngredient toIngredient,
                                UnitOfMeasureToUnitOfMeasureDto toUnitOfMeasureDto) {
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.unitOfMeasureService = unitOfMeasureService;
        this.toIngredientDto = toIngredientDto;
        this.toIngredient = toIngredient;
        this.toUnitOfMeasureDto = toUnitOfMeasureDto;
    }

    @GetMapping(path = "/recipe/{id}/ingredients")
    public String manageIngredients(@PathVariable Long id, Model model) {
        Recipe recipe = recipeService.findById(id);
        List<IngredientDto> ingredients =
                toIngredientDto.convertAll(ingredientService.getAllIngredients(id));
        model.addAttribute("ingredients", ingredients);
        model.addAttribute("recipeId", id);
        model.addAttribute("recipeDescription", recipe.getDescription());
        return "recipe/ingredient/manage";
    }

    @GetMapping(path = "/recipe/{recipeId}/ingredient/{ingredientId}/update")
    public String updateIngredient(@PathVariable Long recipeId,
                                   @PathVariable Long ingredientId,
                                   Model model) {
        Ingredient ingredient = ingredientService.getIngredient(ingredientId);
        model.addAttribute("ingredient", toIngredientDto.convert(ingredient));
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("recipeDescription", ingredient.getRecipe().getDescription());
        model.addAttribute("isNewIngredient", false);
        model.addAttribute("unitsOfMeasure",
                toUnitOfMeasureDto.convertAll(unitOfMeasureService.getAllUnitsOfMeasure()));
        return "recipe/ingredient/ingredientForm";
    }

    @GetMapping(path = "/recipe/{recipeId}/ingredients/new")
    public String newIngredient(@PathVariable Long recipeId, Model model) {
        Recipe recipe = recipeService.findById(recipeId);
        // TODO: Handle null recipe
        model.addAttribute("ingredient", new IngredientDto());
        model.addAttribute("recipeId", recipeId);
        model.addAttribute("recipeDescription", recipe.getDescription());
        model.addAttribute("isNewIngredient", true);
        model.addAttribute("unitsOfMeasure",
                toUnitOfMeasureDto.convertAll(unitOfMeasureService.getAllUnitsOfMeasure()));
        return "recipe/ingredient/ingredientForm";
    }

    @PostMapping(path = "/recipe/{recipeId}/ingredient")
    public String saveOrUpdateIngredient(@PathVariable Long recipeId,
                                         @ModelAttribute IngredientDto ingredientDto) {
        Recipe recipe = recipeService.findById(recipeId);
        Ingredient ingredient = ingredientService.save(toIngredient.convert(ingredientDto));
        recipe.addIngredients(ingredient);
        recipeService.save(recipe);
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }

    @GetMapping(path = "/recipe/{recipeId}/ingredient/{ingredientId}/delete")
    public String deleteIngredient(@PathVariable Long recipeId, @PathVariable Long ingredientId) {
        ingredientService.delete(ingredientService.getIngredient(ingredientId));
        return "redirect:/recipe/" + recipeId + "/ingredients";
    }
}
