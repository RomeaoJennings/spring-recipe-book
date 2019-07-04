package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.repositories.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    private final RecipeService recipeService;
    private final IngredientRepository ingredientRepository;

    public IngredientServiceImpl(RecipeService recipeService,
                                 IngredientRepository ingredientRepository) {
        this.recipeService = recipeService;
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public List<Ingredient> getAllIngredients(Long recipeId) {
        List<Ingredient> ingredients = new ArrayList<>();
        Recipe recipe = recipeService.findById(recipeId);
        if (recipe != null) {
            ingredients.addAll(recipe.getIngredients());
        }
        ingredients.sort(Comparator.comparing(Ingredient::getId));
        return ingredients;
    }

    @Override
    public Ingredient getIngredient(Long id) {
        if (id == null) { return null; }
        return ingredientRepository.findById(id).orElse(null);
    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient == null) { return null; }
        return ingredientRepository.save(ingredient);
    }

    @Override
    public void delete(Ingredient ingredient) {
        if (ingredient == null) { return; }
        ingredientRepository.delete(ingredient);
    }
}
