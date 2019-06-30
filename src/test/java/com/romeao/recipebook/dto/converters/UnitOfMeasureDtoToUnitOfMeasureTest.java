package com.romeao.recipebook.dto.converters;

import com.romeao.recipebook.domain.UnitOfMeasure;
import com.romeao.recipebook.dto.UnitOfMeasureDto;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasureDtoToUnitOfMeasureTest {

    private static final Long ID = 1234L;
    private static final String DESCRIPTION = "testDescription";

    private UnitOfMeasureDtoToUnitOfMeasure unitOfMeasureDtoToUnitOfMeasure =
            new UnitOfMeasureDtoToUnitOfMeasure();
    private UnitOfMeasureDto dto;

    @Before
    public void setUp() {
        dto = new UnitOfMeasureDto();
        dto.setDescription(DESCRIPTION);
        dto.setId(ID);
    }

    @Test
    public void nullObject() {
        assertNull(unitOfMeasureDtoToUnitOfMeasure.convert(null));
    }

    @Test
    public void convert() {
        UnitOfMeasure unitOfMeasure = unitOfMeasureDtoToUnitOfMeasure.convert(dto);

        assertNotNull(unitOfMeasure);
        assertEquals(ID, unitOfMeasure.getId());
        assertEquals(DESCRIPTION, unitOfMeasure.getDescription());
    }
}