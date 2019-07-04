package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.Ingredient;

import java.util.List;

public interface IngredientService {

    List<Ingredient> getAllIngredients(Long recipeId);

    Ingredient getIngredient(Long id);

    Ingredient save(Ingredient ingredient);

    void delete(Ingredient ingredient);
}
