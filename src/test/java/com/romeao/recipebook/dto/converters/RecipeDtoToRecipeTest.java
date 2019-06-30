package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Difficulty;
import com.romeao.recipebook.domain.Recipe;
import com.romeao.recipebook.dto.NotesDto;
import com.romeao.recipebook.dto.RecipeDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeDtoToRecipeTest {

    private static final Long ID = 25L;
    private static final String DESCRIPTION = "test_description";
    private static final Integer PREP_TIME = 15;
    private static final Integer COOK_TIME = 3;
    private static final Integer SERVINGS = 4;
    private static final String SOURCE = "test_source";
    private static final String URL = "test_url";
    private static final String DIRECTIONS = "test_directions";
    private static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    private static final NotesDto NOTES = new NotesDto();

    private RecipeDtoToRecipe recipeDtoToRecipe = new RecipeDtoToRecipe(
            new IngredientDtoToIngredient(new UnitOfMeasureDtoToUnitOfMeasure()),
            new CategoryDtoToCategory(), new NotesDtoToNotes());
    private RecipeDto dto;

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
        dto.setNotes(NOTES);
    }

    @Test
    public void nullObject() {
        assertNull(recipeDtoToRecipe.convert(null));
    }

    @Test
    public void convert() {
        Recipe recipe = recipeDtoToRecipe.convert(dto);
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
}