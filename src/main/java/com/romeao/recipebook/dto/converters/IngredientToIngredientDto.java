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
            IngredientDto command = new IngredientDto();
            command.setId(ingredient.getId());
            command.setAmount(ingredient.getAmount());
            command.setDescription(ingredient.getDescription());
            command.setUnitOfMeasure(unitOfMeasureConverter.convert(ingredient.getUnitOfMeasure()));
            return command;
        }
    }
}
