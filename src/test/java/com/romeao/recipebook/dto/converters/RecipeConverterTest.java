package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.*;
import com.romeao.recipebook.dto.NotesDto;
import com.romeao.recipebook.dto.RecipeDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeConverterTest {

    private static final Long ID = 25L;
    private static final String DESCRIPTION = "test_description";
    private static final Integer PREP_TIME = 15;
    private static final Integer COOK_TIME = 3;
    private static final Integer SERVINGS = 4;
    private static final String SOURCE = "test_source";
    private static final String URL = "test_url";
    private static final String DIRECTIONS = "test_directions";
    private static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    private static final NotesDto NOTES_DTO = new NotesDto();
    private static final Notes NOTES = new Notes();

    private RecipeDto dto;
    private Recipe recipe;

    @Before
    public void setUp() {
        dto = new RecipeDto();
        dto.setId(ID);
        dto.setDescription(DESCRIPTION);
        dto.setCookTime(COOK_TIME);
        dto.setPrepTime(PREP_TIME);
        dto.setServings(SERVINGS);
        dto.setSource(SOURCE);
        dto.setUrl(URL);
        dto.setDirections(DIRECTIONS);
        dto.setDifficulty(DIFFICULTY);
        dto.setNotes(NOTES_DTO);

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

        Ingredient secondIngredient = new Ingredient();
        secondIngredient.setId(27L);
        recipe.getIngredients().add(new Ingredient());
        recipe.getIngredients().add(secondIngredient);
        recipe.getCategories().add(new Category());
    }

    @Test
    public void convertNullRecipe() {
        assertNull(RecipeConverter.toDto(null));
    }

    @Test
    public void convertNullRecipeDto() {
        assertNull(RecipeConverter.toRecipe(null));
    }

    @Test
    public void convertToRecipe() {
        recipe = RecipeConverter.toRecipe(dto);
        assertNotNull(recipe);
        assertEquals(ID, recipe.getId());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertNotNull(recipe.getNotes());
        assertNotNull(recipe.getIngredients());
        assertNotNull(recipe.getCategories());
    }

    @Test
    public void convertToDto() {
        dto = RecipeConverter.toDto(recipe);
        assertNotNull(dto);
        assertEquals(ID, dto.getId());
        assertEquals(DESCRIPTION, dto.getDescription());
        assertEquals(COOK_TIME, dto.getCookTime());
        assertEquals(PREP_TIME, dto.getPrepTime());
        assertEquals(SERVINGS, dto.getServings());
        assertEquals(SOURCE, dto.getSource());
        assertEquals(URL, dto.getUrl());
        assertEquals(DIRECTIONS, dto.getDirections());
        assertEquals(DIFFICULTY, dto.getDifficulty());
        assertNotNull(dto.getNotes());
        assertNotNull(dto.getIngredients());
        assertEquals(2, dto.getIngredients().size());
        assertNotNull(dto.getCategories());
        assertEquals(1, dto.getCategories().size());
    }
}