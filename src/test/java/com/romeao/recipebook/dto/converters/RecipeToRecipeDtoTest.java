package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.*;
import com.romeao.recipebook.dto.RecipeDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeToRecipeDtoTest {

    private static final Long ID = 25L;
    private static final String DESCRIPTION = "test_description";
    private static final Integer PREP_TIME = 15;
    private static final Integer COOK_TIME = 3;
    private static final Integer SERVINGS = 4;
    private static final String SOURCE = "test_source";
    private static final String URL = "test_url";
    private static final String DIRECTIONS = "test_directions";
    private static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    private static final Notes NOTES = new Notes();

    private RecipeToRecipeDto recipeToRecipeDto = new RecipeToRecipeDto(
            new NotesToNotesDto(),
            new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto()),
            new CategoryToCategoryDto());
    private Recipe recipe;

    @Before
    public void setUp() {
        recipe = Recipe.builder()
                .id(ID)
                .description(DESCRIPTION)
                .prepTime(PREP_TIME)
                .cookTime(COOK_TIME)
                .servings(SERVINGS)
                .source(SOURCE)
                .url(URL)
                .directions(DIRECTIONS)
                .difficulty(DIFFICULTY)
                .notes(NOTES)
                .build();
        recipe.getIngredients().add(new Ingredient());
        recipe.getIngredients().add(new Ingredient());
        recipe.getCategories().add(new Category());
    }

    @Test
    public void nullObject() {
        assertNull(recipeToRecipeDto.convert(null));
    }

    @Test
    public void convert() {
        RecipeDto command = recipeToRecipeDto.convert(recipe);
        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(COOK_TIME, command.getCookTime());
        assertEquals(PREP_TIME, command.getPrepTime());
        assertEquals(SERVINGS, command.getServings());
        assertEquals(SOURCE, command.getSource());
        assertEquals(URL, command.getUrl());
        assertEquals(DIRECTIONS, command.getDirections());
        assertEquals(DIFFICULTY, command.getDifficulty());
        assertNotNull(command.getNotes());
        assertNotNull(command.getIngredients());
        assertEquals(2, command.getIngredients().size());
        assertNotNull(command.getCategories());
        assertEquals(1, command.getCategories().size());
    }
}