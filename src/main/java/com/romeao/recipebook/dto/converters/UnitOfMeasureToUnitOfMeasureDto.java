package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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

    public List<UnitOfMeasureDto> convertAll(Collection<UnitOfMeasure> unitsOfMeasure) {
        List<UnitOfMeasureDto> list = new ArrayList<>();
        if (unitsOfMeasure == null) { return null; }
        unitsOfMeasure.forEach(uom -> list.add(convert(uom)));
        return list;
    }
}
