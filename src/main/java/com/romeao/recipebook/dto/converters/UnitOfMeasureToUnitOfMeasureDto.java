package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureToUnitOfMeasureDto implements Converter<UnitOfMeasure,
        UnitOfMeasureDto> {
    @Override
    public UnitOfMeasureDto convert(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure == null) { return null; } else {
            UnitOfMeasureDto command = new UnitOfMeasureDto();
            command.setId(unitOfMeasure.getId());
            command.setDescription(unitOfMeasure.getDescription());
            return command;
        }
    }
}
