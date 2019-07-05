package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.dto.IngredientDto;

import java.util.ArrayList;
import java.util.List;

public class IngredientConverter {

    public static Ingredient toIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null) { return null; }
        return Ingredient.builder()
                .id(ingredientDto.getId())
                .amount(ingredientDto.getAmount())
                .description(ingredientDto.getDescription())
                .unitOfMeasure(UnitOfMeasureConverter.toUnitOfMeasure(
                        ingredientDto.getUnitOfMeasure()))
                .build();
    }

    public static IngredientDto toDto(Ingredient ingredient) {
        if (ingredient == null) { return null; }

        IngredientDto dto = new IngredientDto();
        dto.setId(ingredient.getId());
        dto.setAmount(ingredient.getAmount());
        dto.setDescription(ingredient.getDescription());
        dto.setUnitOfMeasure(UnitOfMeasureConverter.toDto(ingredient.getUnitOfMeasure()));
        dto.setDisplayName(ingredient.getDisplayName());
        return dto;
    }

    public static List<IngredientDto> convertAllIngredients(Iterable<Ingredient> ingredients) {
        List<IngredientDto> list = new ArrayList<>();
        if (ingredients != null) {
            ingredients.forEach(ingredient -> list.add(toDto(ingredient)));
        }
        return list;
    }

}
