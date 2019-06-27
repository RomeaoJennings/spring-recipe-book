package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();

    Recipe findById(Long id);
}

