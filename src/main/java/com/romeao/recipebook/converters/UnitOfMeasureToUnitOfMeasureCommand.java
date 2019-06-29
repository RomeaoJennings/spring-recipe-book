package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.UnitOfMeasureCommand;
import com.romeao.recipebook.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureCommand implements Converter<UnitOfMeasure,
        UnitOfMeasureCommand> {
    @Override
    public UnitOfMeasureCommand convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure == null) { return null; } else {
            UnitOfMeasureCommand command = new UnitOfMeasureCommand();
            command.setId(unitOfMeasure.getId());
            command.setDescription(unitOfMeasure.getDescription());
            return command;
        }
    }
}
