package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.IngredientCommand;
import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.UnitOfMeasure;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientCommandTest {

    private static final Long ID = 816L;
    private static final BigDecimal AMOUNT = new BigDecimal(3.14);
    private static final String DESCRIPTION = "testDescription";
    private static final UnitOfMeasure UOM = UnitOfMeasure.builder().id(1L).build();

    private IngredientToIngredientCommand ingredientToIngredientCommand =
            new IngredientToIngredientCommand(new UnitOfMeasureToUnitOfMeasureCommand());

    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = Ingredient.builder()
                .id(ID).description(DESCRIPTION)
                .amount(AMOUNT)
                .unitOfMeasure(UOM)
                .build();
    }

    @Test
    public void nullObject() {
        assertNull(ingredientToIngredientCommand.convert(null));
    }

    @Test
    public void convert() {
        IngredientCommand command = ingredientToIngredientCommand.convert(ingredient);
        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
        assertNotNull(command.getUnitOfMeasure());
    }
}