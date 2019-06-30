package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.dto.IngredientDto;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientDtoToIngredientTest {

    private static final Long ID = 816L;
    private static final BigDecimal AMOUNT = new BigDecimal(3.14);
    private static final String DESCRIPTION = "testDescription";
    private static final UnitOfMeasureDto UOM_DTO = new UnitOfMeasureDto();

    private IngredientDtoToIngredient ingredientDtoToIngredient =
            new IngredientDtoToIngredient(new UnitOfMeasureDtoToUnitOfMeasure());
    private IngredientDto dto;

    @Before
    public void setUp() {
        UOM_DTO.setId(ID);
        UOM_DTO.setDescription(DESCRIPTION);

        dto = new IngredientDto();
        dto.setId(ID);
        dto.setDescription(DESCRIPTION);
        dto.setAmount(AMOUNT);
        dto.setUnitOfMeasure(UOM_DTO);
    }

    @Test
    public void nullObject() {
        assertNull(ingredientDtoToIngredient.convert(null));
    }

    @Test
    public void convert() {
        Ingredient ingredient = ingredientDtoToIngredient.convert(dto);
        assertNotNull(ingredient);
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertNotNull(ingredient.getUnitOfMeasure());
    }
}