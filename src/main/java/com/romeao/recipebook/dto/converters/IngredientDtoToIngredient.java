package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.Ingredient;
import com.romeao.recipebook.dto.IngredientDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientDtoToIngredient implements Converter<IngredientDto, Ingredient> {

    private final UnitOfMeasureDtoToUnitOfMeasure unitOfMeasureConverter;

    public IngredientDtoToIngredient(UnitOfMeasureDtoToUnitOfMeasure uomConverter) {
        this.unitOfMeasureConverter = uomConverter;
    }

    @Override
    public Ingredient convert(IngredientDto ingredientDto) {
        if (ingredientDto == null) { return null; } else {
            return Ingredient.builder()
                    .id(ingredientDto.getId())
                    .amount(ingredientDto.getAmount())
                    .description(ingredientDto.getDescription())
                    .unitOfMeasure(unitOfMeasureConverter.convert(
                            ingredientDto.getUnitOfMeasure()))
                    .build();
        }
    }
}
