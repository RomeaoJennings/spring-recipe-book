package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UnitOfMeasureDtoToUnitOfMeasure implements Converter<UnitOfMeasureDto,
        UnitOfMeasure> {
    @Override
    public UnitOfMeasure convert(UnitOfMeasureDto unitOfMeasureDto) {
        if (unitOfMeasureDto == null) { return null; } else {
            return UnitOfMeasure.builder()
                    .id(unitOfMeasureDto.getId())
                    .description(unitOfMeasureDto.getDescription())
                    .build();
        }
    }
}
