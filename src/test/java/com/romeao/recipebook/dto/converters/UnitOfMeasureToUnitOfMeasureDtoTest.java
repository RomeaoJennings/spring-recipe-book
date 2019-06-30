package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureToUnitOfMeasureDtoTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private UnitOfMeasureToUnitOfMeasureDto unitOfMeasureToUnitOfMeasureDto
            = new UnitOfMeasureToUnitOfMeasureDto();
    private UnitOfMeasure unitOfMeasure;

    @Before
    public void setUp() {
        unitOfMeasure = UnitOfMeasure.builder()
                .id(ID)
                .description(DESCRIPTION)
                .build();
    }

    @Test
    public void nullObject() {
        assertNull(unitOfMeasureToUnitOfMeasureDto.convert(null));
    }

    @Test
    public void convert() {
        UnitOfMeasureDto command = unitOfMeasureToUnitOfMeasureDto.convert(unitOfMeasure);

        assertNotNull(command);
        assertEquals(ID, command.getId());
        assertEquals(DESCRIPTION, command.getDescription());
    }
}