package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.NotesCommand;
import com.romeao.recipebook.commands.RecipeCommand;
import com.romeao.recipebook.domain.Difficulty;
import com.romeao.recipebook.domain.Recipe;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecipeCommandToRecipeTest {

    private static final Long ID = 25L;
    private static final String DESCRIPTION = "test_description";
    private static final Integer PREP_TIME = 15;
    private static final Integer COOK_TIME = 3;
    private static final Integer SERVINGS = 4;
    private static final String SOURCE = "test_source";
    private static final String URL = "test_url";
    private static final String DIRECTIONS = "test_directions";
    private static final Difficulty DIFFICULTY = Difficulty.MODERATE;
    private static final NotesCommand NOTES = new NotesCommand();

    private RecipeCommandToRecipe recipeCommandToRecipe = new RecipeCommandToRecipe(
            new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure()),
            new CategoryCommandToCategory(), new NotesCommandToNotes());
    private RecipeCommand command;

    @Before
    public void setUp() {
        command = new RecipeCommand();
        command.setId(ID);
        command.setDescription(DESCRIPTION);
        command.setCookTime(COOK_TIME);
        command.setPrepTime(PREP_TIME);
        command.setServings(SERVINGS);
        command.setSource(SOURCE);
        command.setUrl(URL);
        command.setDirections(DIRECTIONS);
        command.setDifficulty(DIFFICULTY);
        command.setNotes(NOTES);
    }

    @Test
    public void nullObject() {
        assertNull(recipeCommandToRecipe.convert(null));
    }

    @Test
    public void convert() {
        Recipe recipe = recipeCommandToRecipe.convert(command);
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