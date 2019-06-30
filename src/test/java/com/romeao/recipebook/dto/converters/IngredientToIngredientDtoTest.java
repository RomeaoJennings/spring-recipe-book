package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.IngredientDto;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class IngredientToIngredientDtoTest {

    private static final Long ID = 816L;
    private static final BigDecimal AMOUNT = new BigDecimal(3.14);
    private static final String DESCRIPTION = "testDescription";
    private static final UnitOfMeasure UOM = UnitOfMeasure.builder().id(1L).build();

    private IngredientToIngredientDto ingredientToIngredientDto =
            new IngredientToIngredientDto(new UnitOfMeasureToUnitOfMeasureDto());

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
        assertNull(ingredientToIngredientDto.convert(null));
    }

    @Test
    public void convert() {
        IngredientDto command = ingredientToIngredientDto.convert(ingredient);
        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
        assertEquals(AMOUNT, command.getAmount());
        assertNotNull(command.getUnitOfMeasure());
    }
}