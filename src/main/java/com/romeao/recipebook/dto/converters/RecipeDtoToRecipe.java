package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.RecipeDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeDtoToRecipe implements Converter<RecipeDto, Recipe> {
    private final IngredientDtoToIngredient ingredientConverter;
    private final CategoryDtoToCategory categoryConverter;
    private final NotesDtoToNotes notesConverter;

    public RecipeDtoToRecipe(IngredientDtoToIngredient ingredientConverter,
                             CategoryDtoToCategory categoryConverter,
                             NotesDtoToNotes notesConverter) {
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
        this.notesConverter = notesConverter;
    }

    @Override
    public Recipe convert(RecipeDto recipeDto) {
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
                .notes(notesConverter.convert(recipeDto.getNotes()))
                .build();

        recipeDto.getCategories()
                .forEach(cat -> recipe.addCategories(categoryConverter.convert(cat)));
        recipeDto.getIngredients().forEach(ingredient -> recipe.addIngredients(ingredientConverter
                .convert(ingredient)));
        return recipe;
    }
}
