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

        RecipeDto command = new RecipeDto();
        command.setId(recipe.getId());
        command.setDescription(recipe.getDescription());
        command.setCookTime(recipe.getCookTime());
        command.setDifficulty(recipe.getDifficulty());
        command.setDirections(recipe.getDirections());
        command.setPrepTime(recipe.getPrepTime());
        command.setServings(recipe.getServings());
        command.setSource(recipe.getSource());
        command.setUrl(recipe.getUrl());
        command.setNotes(notesConverter.convert(recipe.getNotes()));

        recipe.getCategories()
                .forEach(cat -> command.getCategories().add(categoryConverter.convert(cat)));

        recipe.getIngredients().forEach(ingredient -> command.getIngredients()
                .add(ingredientConverter.convert(ingredient)));
        return command;
    }
}
