package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.IngredientDto;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IngredientConverterTest {

    private static final Long ID = 816L;
    private static final BigDecimal AMOUNT = new BigDecimal(3.14);
    private static final String DESCRIPTION = "testDescription";
    private static final UnitOfMeasureDto UOM_DTO = new UnitOfMeasureDto();
    private static final UnitOfMeasure UOM = UnitOfMeasure.builder().id(1L).build();

    private IngredientDto dto;
    private Ingredient ingredient;

    @Before
    public void setUp() {
        UOM_DTO.setId(ID);
        UOM_DTO.setDescription(DESCRIPTION);

        dto = new IngredientDto();
        dto.setId(ID);
        dto.setDescription(DESCRIPTION);
        dto.setAmount(AMOUNT);
        dto.setUnitOfMeasure(UOM_DTO);

        ingredient = Ingredient.builder()
                .id(ID).description(DESCRIPTION)
                .amount(AMOUNT)
                .unitOfMeasure(UOM)
                .build();

    }

    @Test
    public void convertNullDto() {
        assertNull(IngredientConverter.toIngredient(null));
    }

    @Test
    public void convertNullIngredient() {
        assertNull(IngredientConverter.toDto(null));
    }

    @Test
    public void convertToIngredient() {
        ingredient = IngredientConverter.toIngredient(dto);
        assertNotNull(ingredient);
        assertEquals(ID, ingredient.getId());
        assertEquals(DESCRIPTION, ingredient.getDescription());
        assertEquals(AMOUNT, ingredient.getAmount());
        assertNotNull(ingredient.getUnitOfMeasure());
    }

    @Test
    public void convertToDto() {
        dto = IngredientConverter.toDto(ingredient);
        assertNotNull(dto);
        assertEquals(ID, dto.getId());
        assertEquals(DESCRIPTION, dto.getDescription());
        assertEquals(AMOUNT, dto.getAmount());
        assertNotNull(dto.getUnitOfMeasure());
    }

    @Test
    public void convertAllIngredients() {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(ingredient);
        ingredients.add(ingredient);

        List<IngredientDto> result = IngredientConverter.convertAllIngredients(ingredients);

        assertNotNull(result);
        assertEquals(2, result.size());
    }
}