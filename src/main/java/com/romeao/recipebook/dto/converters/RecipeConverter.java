package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.RecipeDto;
import org.springframework.stereotype.Component;

@Component
public class RecipeConverter {

    public static Recipe toRecipe(RecipeDto recipeDto) {
        if (recipeDto == null) { return null; }

        Recipe recipe = Recipe.builder()
                .id(recipeDto.getId())
                .description(recipeDto.getDescription())
                .cookTime(recipeDto.getCookTime())
                .difficulty(recipeDto.getDifficulty())
                .directions(recipeDto.getDirections())
                .prepTime(recipeDto.getPrepTime())
                .servings(recipeDto.getServings())
                .source(recipeDto.getSource())
                .url(recipeDto.getUrl())
                .notes(NotesConverter.toNotes(recipeDto.getNotes()))
                .build();

        recipeDto.getCategories()
                .forEach(cat -> recipe.addCategories(CategoryConverter.toCategory(cat)));
        recipeDto.getIngredients().forEach(ingredient -> recipe.addIngredients(IngredientConverter.toIngredient(ingredient)));
        return recipe;
    }

    public static RecipeDto toDto(Recipe recipe) {
        if (recipe == null) { return null; }

        RecipeDto dto = new RecipeDto();
        dto.setId(recipe.getId());
        dto.setDescription(recipe.getDescription());
        dto.setCookTime(recipe.getCookTime());
        dto.setDifficulty(recipe.getDifficulty());
        dto.setDirections(recipe.getDirections());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setServings(recipe.getServings());
        dto.setSource(recipe.getSource());
        dto.setUrl(recipe.getUrl());
        dto.setNotes(NotesConverter.toDto(recipe.getNotes()));

        recipe.getCategories()
                .forEach(cat -> dto.getCategories().add(CategoryConverter.toDto(cat)));

        recipe.getIngredients().forEach(ingredient -> dto.getIngredients()
                .add(IngredientConverter.toDto(ingredient)));
        return dto;
    }
}
