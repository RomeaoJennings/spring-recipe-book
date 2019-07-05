package com.romeao.recipebook.services;

import com.romeao.recipebook.domain.Category;
import com.romeao.recipebook.domain.Recipe;

import java.util.List;
import java.util.Set;

public interface RecipeService {
    Set<Recipe> getAllRecipes();

    Recipe findById(Long id);

    Recipe save(Recipe recipe);

    void deleteById(Long id);

    List<Category> getAllCategories();
}

