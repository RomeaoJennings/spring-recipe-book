package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.RecipeCommand;
import com.romeao.recipebook.domain.Recipe;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final IngredientCommandToIngredient ingredientConverter;
    private final CategoryCommandToCategory categoryConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(IngredientCommandToIngredient ingredientConverter,
                                 CategoryCommandToCategory categoryConverter,
                                 NotesCommandToNotes notesConverter) {
        this.ingredientConverter = ingredientConverter;
        this.categoryConverter = categoryConverter;
        this.notesConverter = notesConverter;
    }

    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if (recipeCommand == null) { return null; }

        Recipe recipe = Recipe.builder()
                .id(recipeCommand.getId())
                .description(recipeCommand.getDescription())
                .cookTime(recipeCommand.getCookTime())
                .difficulty(recipeCommand.getDifficulty())
                .directions(recipeCommand.getDirections())
                .prepTime(recipeCommand.getPrepTime())
                .servings(recipeCommand.getServings())
                .source(recipeCommand.getSource())
                .url(recipeCommand.getUrl())
                .notes(notesConverter.convert(recipeCommand.getNotes()))
                .build();

        recipeCommand.getCategories()
                .forEach(cat -> recipe.addCategories(categoryConverter.convert(cat)));
        recipeCommand.getIngredients().forEach(ingredient -> recipe.addIngredients(ingredientConverter
                .convert(ingredient)));
        return recipe;
    }
}
