package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.IngredientCommand;
import com.romeao.recipebook.domain.Ingredient;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class IngredientToIngredientCommand implements Converter<Ingredient, IngredientCommand> {
    private final UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter;

    public IngredientToIngredientCommand(UnitOfMeasureToUnitOfMeasureCommand unitOfMeasureConverter) {
        this.unitOfMeasureConverter = unitOfMeasureConverter;
    }

    @Override
    public IngredientCommand convert(Ingredient ingredient) {
        if (ingredient == null) { return null; } else {
            IngredientCommand command = new IngredientCommand();
            command.setId(ingredient.getId());
            command.setAmount(ingredient.getAmount());
            command.setDescription(ingredient.getDescription());
            command.setUnitOfMeasure(unitOfMeasureConverter.convert(ingredient.getUnitOfMeasure()));
            return command;
        }
    }
}
