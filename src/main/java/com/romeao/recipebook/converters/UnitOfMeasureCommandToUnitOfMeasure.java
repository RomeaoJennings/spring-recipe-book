package com.romeao.recipebook.converters;

import com.romeao.recipebook.commands.UnitOfMeasureCommand;
import com.romeao.recipebook.domain.UnitOfMeasure;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureCommandToUnitOfMeasure implements Converter<UnitOfMeasureCommand,
        UnitOfMeasure> {
    @Override
    public UnitOfMeasure convert(UnitOfMeasureCommand unitOfMeasureCommand) {
        if (unitOfMeasureCommand == null) { return null; } else {
            return UnitOfMeasure.builder()
                    .id(unitOfMeasureCommand.getId())
                    .description(unitOfMeasureCommand.getDescription())
                    .build();
        }
    }
}
