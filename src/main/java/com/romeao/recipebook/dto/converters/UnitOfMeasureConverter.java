package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;

import java.util.ArrayList;
import java.util.List;

public class UnitOfMeasureConverter {

    public static UnitOfMeasure toUnitOfMeasure(UnitOfMeasureDto unitOfMeasureDto) {
        if (unitOfMeasureDto == null) { return null; }
        return UnitOfMeasure.builder()
                .id(unitOfMeasureDto.getId())
                .description(unitOfMeasureDto.getDescription())
                .build();

    }

    public static UnitOfMeasureDto toDto(UnitOfMeasure unitOfMeasure) {
        if (unitOfMeasure == null) { return null; }
        UnitOfMeasureDto dto = new UnitOfMeasureDto();
        dto.setId(unitOfMeasure.getId());
        dto.setDescription(unitOfMeasure.getDescription());
        return dto;
    }

    public static List<UnitOfMeasureDto> convertAllUnitsOfMeasure(
            Iterable<UnitOfMeasure> unitsOfMeasure) {
        List<UnitOfMeasureDto> list = new ArrayList<>();
        if (unitsOfMeasure == null) { return null; }
        unitsOfMeasure.forEach(uom -> list.add(toDto(uom)));
        return list;
    }
}
