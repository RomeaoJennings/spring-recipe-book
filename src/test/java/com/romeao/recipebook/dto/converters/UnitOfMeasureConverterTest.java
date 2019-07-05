package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UnitOfMeasureConverterTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private UnitOfMeasureDto dto;
    private UnitOfMeasure unitOfMeasure;

    @Before
    public void setUp() {
        // We set up both objects, but only use the appropriate one, based on which
        // direction conversion occurs in the tests.
        dto = new UnitOfMeasureDto();
        dto.setDescription(DESCRIPTION);
        dto.setId(ID);

        unitOfMeasure = UnitOfMeasure.builder()
                .id(ID)
                .description(DESCRIPTION)
                .build();
    }

    @Test
    public void convertNullUnitOfMeasure() {
        assertNull(UnitOfMeasureConverter.toDto(null));
    }

    @Test
    public void convertNullUnitOfMeasureDto() {
        assertNull(UnitOfMeasureConverter.toUnitOfMeasure(null));
    }

    @Test
    public void convertToUnitOfMeasure() {
        unitOfMeasure = UnitOfMeasureConverter.toUnitOfMeasure(dto);

        assertNotNull(unitOfMeasure);
        assertEquals(ID, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }

    @Test
    public void convertToDto() {
        dto = UnitOfMeasureConverter.toDto(unitOfMeasure);

        assertNotNull(dto);
        assertEquals(ID, dto.getId());
        assertEquals(DESCRIPTION, dto.getDescription());
    }

    @Test
    public void convertAllUnitsOfMeasure() {
        List<UnitOfMeasure> listToConvert = new ArrayList<>();

        // Add same unit of measure three times.
        listToConvert.add(unitOfMeasure);
        listToConvert.add(unitOfMeasure);
        listToConvert.add(unitOfMeasure);

        List<UnitOfMeasureDto> result =
                UnitOfMeasureConverter.convertAllUnitsOfMeasure(listToConvert);

        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals(DESCRIPTION, result.get(0).getDescription());
        assertEquals(ID, result.get(1).getId());
    }
}