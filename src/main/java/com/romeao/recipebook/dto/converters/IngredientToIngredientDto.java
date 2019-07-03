package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.dto.IngredientDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientDto implements Converter<Ingredient, IngredientDto> {
    private final UnitOfMeasureToUnitOfMeasureDto unitOfMeasureConverter;

    public IngredientToIngredientDto(UnitOfMeasureToUnitOfMeasureDto unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Override
    public IngredientDto convert(Ingredient ingredient) {
        if (ingredient == null) { return null; } else {
            IngredientDto dto = new IngredientDto();
            dto.setId(ingredient.getId());
            dto.setAmount(ingredient.getAmount());
            dto.setDescription(ingredient.getDescription());
            dto.setUnitOfMeasure(unitOfMeasureConverter.convert(ingredient.getUnitOfMeasure()));
            dto.setDisplayName(ingredient.getDisplayName());
            return dto;
        }
    }
}
