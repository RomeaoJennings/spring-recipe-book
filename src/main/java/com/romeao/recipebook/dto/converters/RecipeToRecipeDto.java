package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.RecipeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeToRecipeDto implements Converter<Recipe, RecipeDto> {
    private final NotesToNotesDto notesConverter;
    private final IngredientToIngredientDto ingredientConverter;
    private final CategoryToCategoryDto categoryConverter;

    public RecipeToRecipeDto(NotesToNotesDto notesConverter,
                             IngredientToIngredientDto ingredientConverter,
                             CategoryToCategoryDto categoryConverter) {
        this.notesConverter = notesConverter;
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
    }

    @Override
    public RecipeDto convert(Recipe recipe) {
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
        dto.setNotes(notesConverter.convert(recipe.getNotes()));

        recipe.getCategories()
                .forEach(cat -> dto.getCategories().add(categoryConverter.convert(cat)));

        recipe.getIngredients().forEach(ingredient -> dto.getIngredients()
                .add(ingredientConverter.convert(ingredient)));
        return dto;
    }
}
