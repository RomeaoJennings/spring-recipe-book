package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.IngredientCommand;
import com.romeao.recipebook.commands.UnitOfMeasureCommand;
import com.romeao.recipebook.domain.Ingredient;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientCommandToIngredientTest {

    private static final Long ID = 816L;
    private static final BigDecimal AMOUNT = new BigDecimal(3.14);
    private static final String DESCRIPTION = "testDescription";
    private static final UnitOfMeasureCommand UOM_COMMAND = new UnitOfMeasureCommand();

    private IngredientCommandToIngredient ingredientCommandToIngredient =
            new IngredientCommandToIngredient(new UnitOfMeasureCommandToUnitOfMeasure());
    private IngredientCommand command;

    @Before
    public void setUp() {
        UOM_COMMAND.setId(ID);
        UOM_COMMAND.setDescription(DESCRIPTION);

        command = new IngredientCommand();
        command.setId(ID);
        command.setDescription(DESCRIPTION);
        command.setAmount(AMOUNT);
        command.setUnitOfMeasure(UOM_COMMAND);
    }

    @Test
    public void nullObject() {
        assertNull(ingredientCommandToIngredient.convert(null));
    }

    @Test
    public void convert() {
        Ingredient ingredient = ingredientCommandToIngredient.convert(command);
        assertNotNull(ingredient);
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertNotNull(ingredient.getUnitOfMeasure());
    }
}