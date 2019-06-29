package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.IngredientCommand;
import com.romeao.recipebook.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientCommandToIngredient implements Converter<IngredientCommand, Ingredient> {

    private final UnitOfMeasureCommandToUnitOfMeasure unitOfMeasureConverter;

    public IngredientCommandToIngredient(UnitOfMeasureCommandToUnitOfMeasure uomConverter) {
        this.unitOfMeasureConverter = uomConverter;
    }

    @Override
    public Ingredient convert(IngredientCommand ingredientCommand) {
        if (ingredientCommand == null) { return null; } else {
            return Ingredient.builder()
                    .id(ingredientCommand.getId())
                    .amount(ingredientCommand.getAmount())
                    .description(ingredientCommand.getDescription())
                    .unitOfMeasure(unitOfMeasureConverter.convert(
                            ingredientCommand.getUnitOfMeasure()))
                    .build();
        }
    }
}
