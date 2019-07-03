package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeService recipeService;

    public IngredientServiceImpl(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @Override
    public List<Ingredient> getAllIngredients(Long recipeId) {
        List<Ingredient> ingredients = new ArrayList<>();
        Recipe recipe = recipeService.findById(recipeId);
        if (recipe != null) {
            ingredients.addAll(recipe.getIngredients());
        }
        return ingredients;
    }
}
